package com.spartahacks.app.bargamescores;

/**
 * Created by raviko on 1/21/17.
 */

public class Response<T> {

    private T value;
    private Boolean failed;
    private String failureMsg;

    Response(T value) {
        this.value = value;
    }

    private void setFailedMsg(String msg) {
        this.failed = true;
        this.failureMsg = msg;
    }
}
