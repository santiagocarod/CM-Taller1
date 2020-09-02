package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FibonacciActivity extends AppCompatActivity {

    LinearLayout pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        pantalla = findViewById(R.id.meterTexto);

        Intent intent = getIntent();
        int cantfibo = intent.getIntExtra("nivelfibo", 1);

        int n0 = 0, n1 = 1, n2;
        int count = 0;


        for (int i = 0; i < cantfibo; i++) {

            if (i == 0) {
                TextView text = new TextView(getApplicationContext());
                text.setText(String.valueOf(n0));
                pantalla.addView(text);
            } else if (i == 1) {
                TextView text = new TextView(getApplicationContext());
                text.setText(String.valueOf(n1));
                pantalla.addView(text);
            } else {
                n2 = n1 + n0;
                n0 = n1;
                n1 = n2;
                Log.i("Valor: ", String.valueOf(n2));
                TextView text = new TextView(getApplicationContext());
                text.setText(String.valueOf(n2));
                pantalla.addView(text);

            }
        }
    }
}
