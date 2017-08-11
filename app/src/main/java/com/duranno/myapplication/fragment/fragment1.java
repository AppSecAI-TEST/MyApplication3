package com.duranno.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duranno.myapplication.Model.Person;
import com.duranno.myapplication.R;
import com.google.gson.Gson;

/**
 * Created by duranno on 2017. 8. 3..
 */

public class fragment1 extends Fragment {

    private TextView t;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
        t = (TextView)view.findViewById(R.id.txt);
        t.setText("page1");
        initFunc();
        return view;
    }

    private void initFunc(){
        Person data = jsontoJava();
        String str = String.format("%s\n%s",data.getName(),data.getPhone_number());
        t.setText(str);


    }

    public Person jsontoJava(){
        Gson gson = new Gson();
        String json = "{'name':'김태희','phone_number':'010-1234-5678'}";
        Person java = gson.fromJson(json, Person.class);
        return java;


    }
}
