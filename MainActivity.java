package com.example.photomodifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Thread thread = new Thread(){
          public void run(){
              try {
                  sleep(4000);
              }
                  catch(Exception e) {
                        e.printStackTrace();
                  }
                  finally {
                  Intent intent = new Intent(MainActivity.this , selecter_img_page.class);
                  startActivity(intent);
              }

              }
          }; thread.start();
        }

    }
