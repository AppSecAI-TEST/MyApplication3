package com.duranno.myapplication.Model;

/**
 * Created by duranno on 2017. 8. 4..
 */

public class Contributor {

    String login;
    String html_url;
    int contributions;

    @Override
    public String toString(){

        return login +"("+contributions +")";
    }
}
