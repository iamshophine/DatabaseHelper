package com.example.shophine.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shophine on 11/24/17.
 */

public class SignIn extends AppCompatActivity {

    EditText emailInput, passwordInput;
    String email, password;
    boolean emailOK,passOK;

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        emailInput = (EditText) findViewById(R.id.emailSignIn);
        passwordInput = (EditText) findViewById(R.id.passSignIn);
        email = emailInput.getText().toString();
        password = passwordInput.getText().toString();

    }

    public void login(View view) {
        getSignInInput();
        if((emailOK&&passOK)){

            int flag;
            flag = databaseHelper.validate(emailInput.getText().toString(),passwordInput.getText().toString());
           switch (flag){
               case 1 : {
                   Intent intent = new Intent(this, Test.class);
                   startActivity(intent);
               }
               case -1 : {
                   Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show();
               }
               case 0 : {
                   Toast.makeText(this,"User not registered",Toast.LENGTH_LONG).show();
               }
               default:{
                   Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();

               }

            }
        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();

        }

    }
    public void getSignInInput() {
        email = emailInput.getText().toString();
        password = passwordInput.getText().toString();

        emailOK = checkSignInEmail(email);
        passOK = checkSignInPass(password);
    }
    public boolean checkSignInEmail(String email) {

        if(email.matches("")){
            emailInput.setError("Enter the username");
            return false;
        }
        if (!email.contains("@") || !email.contains("."))
        {
            emailInput.setError("Invalid the email-id");
            return false;

        }
        return true;
    }
    public boolean checkSignInPass(String password){
        if(password.matches("")){
            passwordInput.setError("Enter the password");
            return false;
        }
        return true;

    }

}