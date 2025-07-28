package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaIncepem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_incepem);

        Button explicatiiButton = findViewById(R.id.button2);
        Button testeazaButton = findViewById(R.id.button3);
        Button comparaButton = findViewById(R.id.button4);
        Button useButton = findViewById(R.id.button5);
        Button inapoiButton = findViewById(R.id.button6);

        explicatiiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaIncepem.this, ExplicatiiTeoretice.class);
                startActivity(intent);
            }
        });

        testeazaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaIncepem.this, TesteazaAlgoritm.class);
                startActivity(intent);
            }
        });

        comparaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaIncepem.this, ComparaAlgoritmi.class);
                startActivity(intent);
            }
        });

        useButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaIncepem.this, Use.class);
                startActivity(intent);
            }
        });

        inapoiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaIncepem.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}