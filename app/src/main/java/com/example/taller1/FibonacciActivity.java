package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FibonacciActivity extends AppCompatActivity {

    LinearLayout pantalla;
    ImageButton btnImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        pantalla = findViewById(R.id.meterTexto);
        btnImagen = findViewById(R.id.imageURL);

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

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
