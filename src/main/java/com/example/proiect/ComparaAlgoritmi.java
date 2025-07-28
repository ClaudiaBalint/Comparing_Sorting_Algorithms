package com.example.proiect;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComparaAlgoritmi extends AppCompatActivity {

    private EditText inputValori;
    private EditText inputMinValue;
    private EditText inputMaxValue;
    private EditText inputNumarValori;
    private ListView listViewAlgoritmi1;
    private ListView listViewAlgoritmi2;
    private Button buttonStartComparare;
    private Button buttonGenerateRandom;

    String selectedAlgorithm1;
    String selectedAlgorithm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compara_algoritmi);

        inputValori = findViewById(R.id.inputValori2);
        inputMinValue = findViewById(R.id.inputMinValue2);
        inputMaxValue = findViewById(R.id.inputMaxValue2);
        inputNumarValori = findViewById(R.id.inputNumarValori2);
        buttonGenerateRandom = findViewById(R.id.buttonGenerateRandom2);
        listViewAlgoritmi1 = findViewById(R.id.listViewAlgoritmi2);
        listViewAlgoritmi2 = findViewById(R.id.listViewAlgoritmi3);
        buttonStartComparare = findViewById(R.id.buttonStartSortare2);

        String[] options = getResources().getStringArray(R.array.options_alg);

        ArrayAdapter<String> adapterAlgoritmi1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, options) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color));
                return view;
            }
        };

        listViewAlgoritmi1.setAdapter(adapterAlgoritmi1);

        ArrayAdapter<String> adapterAlgoritmi2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, options) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color));
                return view;
            }
        };

        listViewAlgoritmi2.setAdapter(adapterAlgoritmi2);

        listViewAlgoritmi1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedAlgorithm1 = (String) parent.getItemAtPosition(position);
                Toast.makeText(ComparaAlgoritmi.this, "Primul algoritm selectat: " + selectedAlgorithm1, Toast.LENGTH_SHORT).show();
            }
        });

        listViewAlgoritmi2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedAlgorithm2 = (String) parent.getItemAtPosition(position);
                Toast.makeText(ComparaAlgoritmi.this, "Al doilea algoritm selectat: " + selectedAlgorithm2, Toast.LENGTH_SHORT).show();
            }
        });

        buttonGenerateRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomValues();
            }
        });


        buttonStartComparare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComparison();
            }
        });
    }

    private void generateRandomValues() {

        if (TextUtils.isEmpty(inputMinValue.getText().toString()) ||
                TextUtils.isEmpty(inputMaxValue.getText().toString()) ||
                TextUtils.isEmpty(inputNumarValori.getText().toString())) {
            Toast.makeText(this, "Completați toate câmpurile.", Toast.LENGTH_SHORT).show();
            return;
        }

        Random random = new Random();
        int minValue = Integer.parseInt(inputMinValue.getText().toString());
        int maxValue = Integer.parseInt(inputMaxValue.getText().toString());
        int numberOfValues = Integer.parseInt(inputNumarValori.getText().toString());

        if (numberOfValues <= 0) {
            Toast.makeText(this, "Introduceți un număr valid de valori.", Toast.LENGTH_SHORT).show();
            return;
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;
            values.add(randomValue);
        }

        inputValori.setText(TextUtils.join(",", values));
    }

    private void startComparison() {

        String inputValues = inputValori.getText().toString();
        String minValueString = inputMinValue.getText().toString();
        String maxValueString = inputMaxValue.getText().toString();
        String numarValoriString = inputNumarValori.getText().toString();

        if (TextUtils.isEmpty(inputValues)) {
            Toast.makeText(this, "Adăugați numerele pe care doriți să le sortați.", Toast.LENGTH_SHORT).show();
            return;
        }

        int minValue = Integer.parseInt(minValueString);
        int maxValue = Integer.parseInt(maxValueString);
        int numberOfValues = Integer.parseInt(numarValoriString);

        if (numberOfValues <= 0) {
            Toast.makeText(this, "Introduceți un număr valid de valori.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (minValue >= maxValue) {
            Toast.makeText(this, "Valoarea minimă trebuie să fie mai mică decât valoarea maximă.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(ComparaAlgoritmi.this, RezultatComparare.class);
        intent.putExtra("valori", inputValues);
        intent.putExtra("algoritm1", selectedAlgorithm1);
        intent.putExtra("algoritm2", selectedAlgorithm2);

        startActivity(intent);
    }
}

