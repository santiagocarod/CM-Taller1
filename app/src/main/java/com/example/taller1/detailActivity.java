package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class detailActivity extends AppCompatActivity {

    TextView capital,name,intlName,initials;
    ImageView bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        capital = findViewById(R.id.capital);
        name = findViewById(R.id.name);
        intlName = findViewById(R.id.intlName);
        initials = findViewById(R.id.initials);
        bandera = findViewById(R.id.bandera);


        Intent intent = getIntent();

        capital.setText(intent.getStringExtra("capital"));
        name.setText(intent.getStringExtra("name"));
        intlName.setText(intent.getStringExtra("intlName"));
        initials.setText(intent.getStringExtra("initials"));

        String urlPais = "https://restcountries.eu/rest/v2/alpha/"+intent.getStringExtra("initials");

        final Activity activity = this;


        RequestQueue requestQueue;
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, urlPais, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String urlBandera = response.getString("flag");

                            SvgLoader.pluck().with(activity).setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher).load(urlBandera, bandera);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("JSON",error.toString());

                    }
                });

        requestQueue.add(jsonObjectRequest);




        //SvgLoader.pluck().with(this).setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher).load(urlBandera[0], bandera);
    }


}