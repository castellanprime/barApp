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
    }

    protected void onClickJoinGameActivity(View view){
        Intent intent = new Intent(this, JoinGameActivity.class);
        startActivity(intent);
    }

    protected void onClickCreateGameActivity(View view){
        Intent intent = new Intent(this, CreateGameActivity.class);
        startActivity(intent);
    }
}
