package com.example.myapplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ihope {
    static void hui() throws IOException {
        URL url = new URL("http://sdo.rgsu.net");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // все ок
        } else {
            // ошибка
        }
    }
}
