package com.duranno.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.duranno.myapplication.adapter.TabPagerAdapter;
import com.duranno.myapplication.fragment.fragment1;
import com.duranno.myapplication.fragment.fragment2;
import com.duranno.myapplication.fragment.fragment3;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();

    }

    private void initViewPager(){

        viewPager = (ViewPager) findViewById(R.id.mypage_viewPager);
        tabLayout = (TabLayout) findViewById(R.id.mypage_tabLayout);


        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFragment("page1",new fragment1());
        adapter.addFragment("page2",new fragment2());
        adapter.addFragment("page3",new fragment3());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}
