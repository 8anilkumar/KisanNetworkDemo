package com.anil.kisannetworkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String json = null;
        try {
            InputStream inputStream = getAssets().open("UserContacts.json");
            int sizeOffFile = inputStream.available();
            byte[] bufferData = new byte[sizeOffFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData,"UTF-8");



        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}