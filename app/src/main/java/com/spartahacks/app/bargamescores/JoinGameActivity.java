package com.spartahacks.app.bargamescores;

/**
 * Created by rogal-dorn on 1/20/17.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.Window;
import android.widget.Button;
import android.util.Log;

public class JoinGameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joingame);
    }

    protected void onClickLoadGameFragment(View view){
        EditText box = (EditText) findViewById(R.id.joinactivity_codeInputTextBox);
        String joinCode = box.getText().toString();
    }
}