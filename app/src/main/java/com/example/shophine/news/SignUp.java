package com.example.shophine.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by shophine on 11/25/17.
 */


public class SignUp extends AppCompatActivity {

    private String name, email, pass, conPass, gender, regNo, mobile;
    boolean male, female, others;
    private boolean nameOk,regNoOk,emailOK,passOk,conPassOk,dobOK,genderOK,mobOK;
    EditText nameInput,  regInput , emailInput, passInput, passConInput, mobInput;

    DatabaseHelper databaseHelper = new DatabaseHelper(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        nameInput = (EditText) findViewById(R.id.nameInput);
        regInput = (EditText) findViewById(R.id.regInput);
        emailInput = (EditText) findViewById(R.id.emailInput);
        passInput = (EditText) findViewById(R.id.passInput);
        passConInput = (EditText) findViewById(R.id.conEmailInput);
        mobInput = (EditText) findViewById(R.id.mobInput);

    }
    public void submit(View view) {
        getInput();
        if(nameOk&&regNoOk&&emailOK&&passOk&&conPassOk&&mobOK&&genderOK) {

            User user = new User();
            user.setEmail(email);
            user.setPassword(pass);

            databaseHelper.insert(user);
            Toast.makeText(this,"Registered successfully!",Toast.LENGTH_LONG).show();


            Intent intent = new Intent(this,Test.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
    public void getInput(){
        name = nameInput.getText().toString();
        nameOk=checkName();
        regNo=regInput.getText().toString();
        regNoOk=checkRegNo();
        email = emailInput.getText().toString();
        emailOK=checkEmail();
        pass = passInput.getText().toString();
        passOk=checkPass();
        conPass = passConInput.getText().toString();
        conPassOk=checkConPass();
        mobile=mobInput.getText().toString();
        mobOK=checkMob();
        genderOK=checkGender();
    }
    public boolean checkName(){
        if(name.matches("")){
            nameInput.setError("Enter the name");
            return false;
        }

        return true;
    }
    public boolean checkRegNo(){
        int regLen;
        regLen=regNo.length();
        if(regLen!=10) {
            if(regLen==0){
                regInput.setError("Enter the Reg. No");

            }
            regInput.setError("Invalid Reg. No");
            return false;
        }
        if(regNo.charAt(0)!='2' && regNo.charAt(1)!='0' && regNo.charAt(2)!='1'){
            regInput.setError("Invalid Reg. No");
            return false;
        }
        return true;

    }
    public boolean checkEmail(){
        if(email.matches("")){
            emailInput.setError("Enter the email-id");
            return false;
        }
        if (!email.contains("@") || !email.contains("."))
        {
            emailInput.setError("Invalid the email-id");
            return false;
        }
        return true;
    }
    public boolean checkPass(){
        if(pass.matches("")){
            passInput.setError("Enter the password");
            return false;
        }
        return true;

    }
    public boolean checkConPass(){
        if (!conPass.equals(pass)){
            passConInput.setError("Password doesn't match");
            return false;
        }
        return true;
    }
    public boolean checkMob(){
        int mobLen;
        mobLen=mobile.length();
        if(mobLen!=10) {
            mobInput.setError("Invalid Mobile. No");
            return false;
        }
        if(mobile.charAt(0)!='9' && mobile.charAt(0)!='8' && mobile.charAt(0)!='7'){
            mobInput.setError("Invalid Mobile. No");
            return false;
        }
        return true;


    }
    public boolean checkGender(){
        if(male==true||female==true||others==true){
            return true;
        }else {
            Toast.makeText(this,"Select the gender",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void gender(View view) {

        boolean isChecked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.male:
                if (isChecked) {
                    gender="Male";
                    male = true;
                }
                break;

            case R.id.female:
                if (isChecked) {
                    gender ="Female";
                    female = true;
                }
                break;
            case R.id.other:
                if (isChecked) {
                    gender="Others";
                    others = true;
                }
                break;
        }
    }



}
