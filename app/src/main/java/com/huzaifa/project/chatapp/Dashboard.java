package com.huzaifa.project.chatapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.huzaifa.project.chatapp.Adapters.TabAdapter;
import com.huzaifa.project.chatapp.Fragments.profile;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    FirebaseAuth auth;
    ViewPager pager ;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();
        fragments = new ArrayList<>();
        pager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        Toast.makeText(this,"hello"+auth.getCurrentUser().getEmail(),Toast.LENGTH_LONG).show();
        addFragments();

    }

    @Override
    protected void onStart() {
        super.onStart();
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(),fragments);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    private void addFragments() {
        fragments.add(new profile());
        fragments.add(new profile());
        fragments.add(new profile());
    }



}
