package com.huzaifa.project.chatapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.huzaifa.project.chatapp.Fragments.Signin;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    Button b1;
    EditText e1,e2;
    Context context;
    FragmentTransaction ft;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();

        context = getApplicationContext();
        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
}

    @Override
    protected void onStart() {
        super.onStart();
        ft.replace(R.id.frame,new Signin(auth));
        ft.commit();
    }
}

