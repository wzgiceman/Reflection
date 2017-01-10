package com.wzgiceman.reflection;

/**
 * Created by WZG on 2017/1/10.
 */

public class User {
    private String name;

    private User(String name){
        this.name=name;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getMsg(){
        return  name;
    }
}
