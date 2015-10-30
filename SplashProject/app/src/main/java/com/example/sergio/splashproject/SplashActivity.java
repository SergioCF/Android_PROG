package com.example.sergio.splashproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    // Tiempo que estara visible SplashActivity
    private long SPLASH_DELAY = 5000;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(getApplicationContext(),
                            MainActivity.class);
                    startActivity(mainIntent);
                    // Destruimos esta activity para prevenit
                    // que el usuario retorne aqui presionando el boton Atras
                    finish();
                }
            };

            Timer timer = new Timer();
            timer.schedule(task, SPLASH_DELAY);

    /*
            Intento de carga de gif a traves de un textView,
            Revisar en la correccion

            WebView web  = (WebView) findViewById(R.id.loading);
            web.setBackgroundColor(Color.TRANSPARENT);
            WebSettings webSettings = web.getSettings();
            webSettings.setJavaScriptEnabled(true);
            web.loadUrl("file:///assets/loading_animation.html");

            CODIGO DEL ACTIVITY_SPLASH.XML :

               <WebView
                android:layout_width="128dp"
                android:layout_height="128dp"
                android:id="@+id/loading"
                android:layout_centerVertical="true"
                android:layout_centerHorizontal="true"
              />

    */

        }

}
