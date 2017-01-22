package com.spartahacks.app.bargamescores;

/**
 * Created by rogal-dorn on 1/20/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.util.Log;

public class JoinGameActivity extends AppCompatActivity {

    private static final String TAG = JoinGameActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super.onCreate(savedInstanceState);
        final Button startButton = (Button) findViewById(R.id.joinactivity_submitBtn);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "button pressed");
                // setContentView(R.layout.activity_joingame);
            }
        });
    }
}