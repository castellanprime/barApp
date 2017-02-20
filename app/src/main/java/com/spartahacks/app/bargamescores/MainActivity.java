package com.spartahacks.app.bargamescores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createButton = (Button) findViewById(R.id.create_new_game_button);
        Button joinButton  = (Button) findViewById(R.id.join_game_button);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                createGame(v);
            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                joinGame(v);
            }
        });
    }

    public void createGame(View v){
        Intent intent= new Intent(this, CreateGameActivity.class);
        startActivity(intent);
        finish();
    }

    public void joinGame(View v){
        Intent intent= new Intent(this, JoinGameActivity.class);
        startActivity(intent);
        finish();
    }

}
