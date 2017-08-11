package com.duranno.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duranno on 2017. 8. 4..
 */

public class pojo {

    @SerializedName("contacts")
    @Expose
    private ArrayList<contacts> contacts = new ArrayList<>();

    public ArrayList<contacts> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<contacts> contacts) {
        this.contacts = contacts;
    }
}
