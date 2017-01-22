package com.spartahacks.app.bargamescores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected void onClickJoinGameActivity(View view){
        Intent intent = new Intent(this, JoinGameActivity.class);
        startActivity(intent);
    }

    protected void onClickCreateGameActivity(View view) {
        Intent intent = new Intent(this, CreateGameActivity.class);
        startActivity(intent);
    }
}
