package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        //inflate
        resultado = findViewById(R.id.resultado);

        Intent intent = getIntent();
        String factorial = intent.getStringExtra("factorial");


        String valorResultado = calcularFactorial(factorial);
        resultado.setText(valorResultado);

    }

    private String calcularFactorial(String factorial) {
        int valor = Integer.parseInt(factorial);
        String retorno = factorial+"! = ";
        int acumulado = 1;

        for(int i=valor;i>0;i--){
            acumulado = acumulado * i;
            retorno += String.valueOf(i) +"*";
        }
        retorno = retorno.substring(0,retorno.length()-1);
        retorno += "\nEl resultado es: "+ acumulado;
        return retorno;
    }
}