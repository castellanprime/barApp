package com.spartahacks.app.bargamescores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        final Button createButton = (Button) findViewById(R.id.createGameButton);
        final Button joinGameButton = (Button) findViewById(R.id.joinGameButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Intent intent = Intent(this, CreateGameActivity.class);
                setContentView(R.layout.activity_creategame);
            }
        });

        joinGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_joingame);
            }
        });
    }
}
