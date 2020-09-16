package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView contFibonacci, fechaFibonacci;
    int contadorFactorial = 0;
    int contadorFibonacci = 0;
    private Calendar calendar;
    private Calendar calendar2;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat dateFormat2;
    private String dateFact;
    private String dateFibo;



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
                String number = text.getText().toString();
                if (!number.equals("") && android.text.TextUtils.isDigitsOnly(number)) {
                    Intent intent = new Intent(getBaseContext(), FibonacciActivity.class);
                    intent.putExtra("nivelfibo", Integer.parseInt(number));
                    startActivity(intent);
                    contadorFibonacci += 1;
                    calendar2 = Calendar.getInstance();
                    dateFormat2 = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
                    dateFibo = dateFormat2.format(calendar2.getTime());
                }else{
                    Toast toast = Toast.makeText(getBaseContext(),"Por favor ingrese un numero en Fibonacci",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        contFactorial = findViewById(R.id.contFactorial);
        fechaFactorial = findViewById(R.id.fechaFactorial);

        contFibonacci = findViewById(R.id.contFibonacci);
        fechaFibonacci = findViewById(R.id.fechaFibonacci);

        contFactorial.setText("Factorial: " + String.valueOf(contadorFactorial));
        if(dateFact != null) {
            fechaFactorial.setText("Uso: " + dateFact);
        }

        contFibonacci.setText("Fibonacci: " + String.valueOf(contadorFibonacci));
        if(dateFibo != null){
            fechaFibonacci.setText("Uso: " + dateFibo);
        }
    }

    private void fillArray() {
        opciones = new ArrayList<>();
        for (int i=0;i<16;i++){
            opciones.add(i);
        }
    }
}