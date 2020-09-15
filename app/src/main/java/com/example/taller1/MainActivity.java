package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<Integer> opciones;
    Button factorial,fibonacci;
    EditText text;
    Button paises;
    TextView contFactorial, fechaFactorial;
    int contadorFactorial = 0;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String dateFact;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inflate
        spinner = findViewById(R.id.spinner);
        factorial = findViewById(R.id.FactorialBtn);
        fibonacci = findViewById(R.id.FibonacciBtn);
        paises = findViewById(R.id.paises);
        text = findViewById(R.id.numeroFibonacci);




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
                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
                dateFact = dateFormat.format(calendar.getTime());
            }
        });

        paises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),PaisesActivity.class));
            }
        });

        fibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),FibonacciActivity.class);
                intent.putExtra("nivelfibo",Integer.parseInt(text.getText().toString()));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        contFactorial = findViewById(R.id.contFactorial);
        fechaFactorial = findViewById(R.id.fechaFactorial);

        contFactorial.setText("Factorial: " + String.valueOf(contadorFactorial));
        if(dateFact != null) {
            fechaFactorial.setText("Uso: " + dateFact);
        }
    }

    private void fillArray() {
        opciones = new ArrayList<>();
        for (int i=0;i<16;i++){
            opciones.add(i);
        }

    }

}