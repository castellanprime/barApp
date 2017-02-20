package com.spartahacks.app.bargamescores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Locale;


/**
 * Created by rogal-dorn on 1/31/17.
 */

public class CreateGameActivity extends AppCompatActivity{

    private EditText gameSearch;
    private ExpandableListView gameList;
    private MyListAdapter listAdapter;
    private ArrayList<GameItem> gameItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creategame);

        gameSearch = (EditText) findViewById(R.id.search_games);
        gameList = (ExpandableListView) findViewById(R.id.game_list_view);

        gameList.setDividerHeight(2);
        listAdapter = new MyListAdapter(CreateGameActivity.this, gameItems);
        gameList.setAdapter(listAdapter);

        gameSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO autogenerated sub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO autogenerated sub
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text=gameSearch.getText().toString().toLowerCase(Locale.getDefault());
                CreateGameActivity.this.listAdapter.getFilter().filter(s);
            }
        });

        Button addNewGameButton = (Button)findViewById(R.id.searchPage_add_your_own_game_btn);
        addNewGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                createNewUserGame(v);
            }
        });

    }

    protected void createNewUserGame(View v){

    }


    private void expandAllGroups(){
        int count = listAdapter.getGroupCount();
        for (int i=0; i < count; i++){
            gameList.expandGroup(i);
        }
    }

    private void collapseAllGroups(){
        int count = listAdapter.getGroupCount();
        for (int i=0; i < count; i++){
            gameList.collapseGroup(i);
        }
    }

}