package com.spartahacks.app.bargamescores;


/**
 * Created by rogal-dorn on 2/2/17.
 */

public class GameItem {

    private String gameTitle;
    private boolean userDefined;
    private GameItemDesc gameDesc;

    GameItem(String gameTitle, Boolean userDefined, GameItemDesc gameDesc){
        this.gameTitle = gameTitle;
        this.userDefined = userDefined;
        this.gameDesc = gameDesc;
    }

    public String getGameTitle(){
        return gameTitle;
    }

    public GameItemDesc getGameDescItem(){
        return gameDesc;
    }

    public boolean isUserDefined(){
        return userDefined;
    }
}
