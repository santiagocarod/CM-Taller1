package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<Integer> opciones;
    Button factorial,fibonacci,paises;
    TextView contFactorial;
    int contadorFactorial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inflate
        spinner = findViewById(R.id.spinner);
        factorial = findViewById(R.id.FactorialBtn);
        fibonacci = findViewById(R.id.FibonacciBtn);
        paises = findViewById(R.id.paises);

        fillArray();

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, opciones);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),FactorialActivity.class);
                intent.putExtra("factorial",spinner.getSelectedItem().toString());
                startActivity(intent);
                contadorFactorial +=1;
            }
        });

        paises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),PaisesActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        contFactorial = findViewById(R.id.contFactorial);
        contFactorial.setText("Factorial: " + String.valueOf(contadorFactorial));
    }

    private void fillArray() {
        opciones = new ArrayList<>();
        for (int i=1;i<16;i++){
            opciones.add(i);
        }

    }

}