package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.net.*;
import java.io.*;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.Body;

//retrofit – типобезопасный HTTP Android клиент для взаимодействия с REST-интерфейсами
//Picasso – мощная библиотека для загрузки и кэширования изображений под Android

//This is a very old answer. I definitely won't recommend Apache's client anymore. Instead use either:
//
//OkHttp (https://www.dev2qa.com/android-okhttp3-http-get-post-request-example/)
//HttpUrlConnection
public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);


        String url = "https://rutube.ru/api/accounts/sendpass/phone";
        OkHttpClient client = new OkHttpClient();

//        String url = "https://youla.ru/web-api/auth/request_code";
        final Request request = new Request.Builder()
                .url(url)
                .post(new FormBody.Builder()
                        .add("phone","+79536922901").build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful()){
                    final String myres =response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                             textView.setText(myres);
                        }
                    });
                }
            }
        });
//гнадо гнаучиться созхдавать потокеи, т.ке. в одгному это гнкельзхя дкелать

    }
    void hueta (){

    }
}
