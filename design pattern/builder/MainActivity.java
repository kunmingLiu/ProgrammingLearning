package com.liu.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mobile iPhone = new Mobile.Builder()
                .setBrand("Apple")
                .setOS(Mobile.IOS)
                .setColor(Color.BLACK)
                .setVersion(8)
                .setSize(5)
                .build();

        iPhone.setColor(Color.WHITE);
        iPhone.setVersion(9);

        Mobile zenPhone = new Mobile.Builder()
                .setBrand("Asus")
                .setOS(Mobile.ANDROID)
                .setColor(Color.BLACK)
                .setVersion(25)
                .setSize(6)
                .build();

        zenPhone.setColor(Color.WHITE);
        zenPhone.setVersion(26);

        Log.e("iPhone", "version : "+iPhone.getVersion());
        Log.e("iPhone", "brand : "+iPhone.getBrand());

        Log.e("asus", "version : "+zenPhone.getVersion());
        Log.e("asus", "brand : "+zenPhone.getBrand());

    }

}
