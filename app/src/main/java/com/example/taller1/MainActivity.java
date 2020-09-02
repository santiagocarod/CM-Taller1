package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<Integer> opciones;
    Button factorial,fibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inflate
        spinner = findViewById(R.id.spinner);
        factorial = findViewById(R.id.FactorialBtn);
        fibonacci = findViewById(R.id.FibonacciBtn);

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
            }
        });


    }

    private void fillArray() {
        opciones = new ArrayList<>();
        for (int i=0;i<16;i++){
            opciones.add(i);
        }

    }

}