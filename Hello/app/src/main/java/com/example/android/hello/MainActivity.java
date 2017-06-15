package com.example.android.hello;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.spinner);
        Button testLiveness;

        InputStream live = null;
        InputStream spoof = null;

        try {
            live = getAssets().open("live");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            spoof = getAssets().open("spoof");
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream testFolders = spoof + live;

        String[] f = null;
        try {
            f = getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(String f1 : f){
//            Log.v("names",f1);
//        }

        ArrayAdapter<String> spinnerArray= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, f);
        spinnerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArray);

        System.out.println("VARNEY: " + f[0]);
        System.out.println("VARNEY: " + f[1]);

    }

}

