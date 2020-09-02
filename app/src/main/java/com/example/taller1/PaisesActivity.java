package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PaisesActivity extends AppCompatActivity {
    String [] arreglo;
    ListView listView;
    ArrayList<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        listView = findViewById(R.id.listView);

        initArray();

        try {
            getPaises();
        } catch (JSONException e) {
            Log.i("JSON", String.valueOf(e));
        }

        final ArrayAdapter<Pais> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,paises);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pais pais = (Pais) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getBaseContext(),detailActivity.class);
                intent.putExtra("capital",pais.getCapital());
                intent.putExtra("name",pais.getName());
                intent.putExtra("intlName",pais.getInternationalName());
                intent.putExtra("initials",pais.getInitials());
                startActivity(intent);
            }
        });
    }

    private void initArray(){
        arreglo = new String[30];
        for(int i = 0; i< arreglo.length;i++){
            if(i%2==0){
                arreglo[i]="Hola";
            }else{
                arreglo[i]="Mundo";
            }
        }
    }

    private void getPaises() throws JSONException {
        paises = new ArrayList<>();
        JSONObject json = new JSONObject(loadJSONFromAsset());
        JSONArray paisesJsonArray = json.getJSONArray("paises");
        for (int i = 0 ; i<paisesJsonArray.length();i++){
            JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
            String capital = jsonObject.getString("capital");
            String name = jsonObject.getString("nombre_pais");
            String internationalName = jsonObject.getString("nombre_pais_int");
            String initials = jsonObject.getString("sigla");
            Pais p = new Pais(capital,name,internationalName,initials);
            paises.add(p);
        }


    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.i("JSON", String.valueOf(ex));
        }
        return json;
    }
}