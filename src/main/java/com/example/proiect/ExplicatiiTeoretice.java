package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExplicatiiTeoretice extends AppCompatActivity {

    private ListView listView;
    private TextView textViewExplicatie;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicatii_teoretice);

        listView = findViewById(R.id.listView);

        textViewExplicatie = findViewById(R.id.textViewExplicatie);
        imageView = findViewById(R.id.imageView); // Initialize ImageView
        Button inapoiButton = findViewById(R.id.button8);

        String[] options = getResources().getStringArray(R.array.options_alg);

        ArrayAdapter<String> adapterAlgoritmi = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, options) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color));
                return view;
            }
        };

        listView.setAdapter(adapterAlgoritmi);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String algoritm = (String) parent.getItemAtPosition(position);
            afiseazaExplicatie(algoritm);
        });

        inapoiButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExplicatiiTeoretice.this, SaIncepem.class);
            startActivity(intent);
        });
    }

    private void afiseazaExplicatie(String algoritm) {
        String fileName = "";
        int imageResource = 0;
        switch (algoritm) {
            case "Bubble Sort":
                fileName = "bubblesort.txt";
                imageResource = R.drawable.bubblesort;
                break;
            case "Selection Sort":
                fileName = "selectionsort.txt";
                imageResource = R.drawable.selectionsort;
                break;
            case "Insertion Sort":
                fileName = "insertionsort.txt";
                imageResource = R.drawable.insertionsort;
                break;
            case "Merge Sort":
                fileName = "mergesort.txt";
                imageResource = R.drawable.mergesort;
                break;
            case "Quick Sort":
                fileName = "quicksort.txt";
                imageResource = R.drawable.quicksort;
                break;
            default:
                textViewExplicatie.setText("Nu există explicație pentru acest algoritm.");
                imageView.setImageResource(0);
                return;
        }

        imageView.setImageResource(imageResource);

        String explicatie = citesteFisierDinResurse(fileName);
        textViewExplicatie.setText(explicatie);
    }

    private String citesteFisierDinResurse(String fileName) {
        InputStream inputStream = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            inputStream = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            Toast.makeText(this, "Eroare la citirea fișierului " + fileName, Toast.LENGTH_SHORT).show();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
