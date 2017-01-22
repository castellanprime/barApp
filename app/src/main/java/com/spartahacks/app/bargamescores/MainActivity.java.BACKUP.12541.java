package com.spartahacks.app.bargamescores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected void onClickJoinGameActivity(View view){
        Intent intent = new Intent(this, JoinGameActivity.class);
        startActivity(intent);
    }

    protected void onClickCreateGameActivity(View view){
        Intent intent = new Intent(this, CreateGameActivity.class);
        startActivity(intent);
=======

        final Button createGameButton = (Button) findViewById(R.id.createGameButton);
        final Button joinGameButton = (Button) findViewById(R.id.joinGameButton);
        final Button sendSpamButton = (Button) findViewById(R.id.sendSpamButton);

        sendSpamButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "spam button clicked");
                String url = getResources().getString(R.string.api_url);
                String port = getResources().getString(R.string.api_port);
                ScoreSender activity = new ScoreSender(url, port);
                activity.postScore(3);
            }
        });

        createGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "createGameButton pressed");
                setContentView(R.layout.activity_creategame);
            }
        });

        joinGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "joinGameButton pressed");
                setContentView(R.layout.activity_joingame);
            }
        });
>>>>>>> 981c2084a72ac2c37cad7dcbccccda54a6533de6
    }
}
