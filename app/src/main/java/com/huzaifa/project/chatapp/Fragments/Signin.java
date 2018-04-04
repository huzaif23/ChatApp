package com.huzaifa.project.chatapp.Fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.huzaifa.project.chatapp.Dashboard;
import com.huzaifa.project.chatapp.R;


public class Signin extends Fragment{


    EditText e1,e2;
    Button b1;
    TextView t1,t2;
    FirebaseAuth auth;
    android.support.v4.app.FragmentTransaction ft ;
    @SuppressLint("ValidFragment")
    public Signin(FirebaseAuth auth) {
        this.auth = auth;

    }


    public Signin() {

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signin,null,false);
        e1=(EditText) v.findViewById(R.id.editText);
        e2 = (EditText) v.findViewById(R.id.editText2);
        b1=(Button) v.findViewById(R.id.btn);
        t1=(TextView) v.findViewById(R.id.txt);
        t2 = (TextView) v.findViewById(R.id.txt4);
        ft = getFragmentManager().beginTransaction();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x= e1.getText().toString();
                String y = e2.getText().toString();
                if (x!=null && y!=null) {
                    authenticate(x,y);
                }
                else {
                    Toast.makeText(getActivity(),"Please enter valid email and password",Toast.LENGTH_SHORT).show();
                }
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft.replace(R.id.frame,new Signup());
                ft.commit();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;

    }

    private void authenticate(String x,String y) {

        auth.signInWithEmailAndPassword(x,y).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(getActivity(),"Hello"+user.getDisplayName(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(),"not working"+task.getException(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
