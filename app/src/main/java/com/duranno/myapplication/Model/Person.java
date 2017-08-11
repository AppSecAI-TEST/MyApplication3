package com.duranno.myapplication.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by duranno on 2017. 8. 3..
 */

public class Person {

    //json 이름이랑 똑같이 해줘야함
    public  String getName() {
        return name;
    }


    public String getPhone_number() {
        return phone_number;
    }

    @SerializedName("name")
    String name;
    @SerializedName("phone_number")
    String phone_number;

    Person(String name, String phonenumber){
        this.name = name;
        this.phone_number = phonenumber;
    }
}
