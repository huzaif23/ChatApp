package com.huzaifa.project.chatapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.huzaifa.project.chatapp.Dashboard;
import com.huzaifa.project.chatapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Signup extends Fragment {

    EditText email,pass;
    Button b1;
    FirebaseAuth mAuth;



    public Signup() {

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signout,container,false);
        email = (EditText) view.findViewById(R.id.editText);
        pass = (EditText) view.findViewById(R.id.editText2);
        b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = email.getText().toString();
                String y = pass.getText().toString();
                auth(x,y);
            }
        });
        return view;
    }

    private void auth(String x,String y) {
     mAuth.createUserWithEmailAndPassword(x,y).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if (task.isSuccessful()) {
                 Intent intent = new Intent(getActivity(), Dashboard.class);
                 startActivity(intent);
             }
             else {
                 Toast.makeText(getActivity(),"Failed"+task.getException(),Toast.LENGTH_LONG).show();
             }
         }
     });
    }

}
