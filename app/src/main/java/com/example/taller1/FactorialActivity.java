package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        resultado.setText(factorial);
    }
}