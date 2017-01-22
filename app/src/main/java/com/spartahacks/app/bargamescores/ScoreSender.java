package com.spartahacks.app.bargamescores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

/**
 * Created by raviko on 1/21/17.
 */

public class ScoreSender {
    private static final String TAG = ScoreSender.class.getSimpleName();
    final private String baseUrl;

    ScoreSender(String url, String port) {
        this.baseUrl = "http://" + url + ":" + port + "/games";
    }

    private Response<String> postScoreToServer(int score, int gameId) {
        HttpURLConnection connection;
        OutputStreamWriter request = null;
        URL url = null;
        try {
            url = new URL(this.baseUrl + "/" + String.valueOf(gameId));
            Log.d(TAG, "Connecting to " + this.baseUrl + "/" + String.valueOf(gameId));
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            Log.d(TAG, "wtf");

            final String json = "{\"score\":\"" + String.valueOf(score) + "\"}";
            request = new OutputStreamWriter(connection.getOutputStream());
            Log.d(TAG, json + " sent");
            request.write(json);
            request.flush();
            request.close();

            String line = "";
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            // Response from server after login process will be stored in response variable.
            String response = sb.toString();
            // You can perform UI operations here
            Log.d(TAG, response);
            //Toast.makeText(this,"Message from Server: \n"+ response, 0).show();
            isr.close();
            reader.close();

        } catch (java.io.IOException e) {
            Log.d(TAG, "WTF "+ e.getMessage());
        }

        return new Response<>("test");
    }

    public void postScore(final int score) {
        Runnable func = new Runnable() {
            public void run() {
                postScoreToServer(score, 1);
            }
        };

        Thread th = new Thread(func);
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {}
    }
}