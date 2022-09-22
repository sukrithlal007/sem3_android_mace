package com.example.customtoast;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void registerFunc(View view) {
        String username,password;

        username = ((EditText) findViewById(R.id.username)).getText().toString();
        password = ((EditText) findViewById(R.id.password)).getText().toString();

        SharedPreferences sp = getSharedPreferences("MyInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();

        Toast.makeText(this,"Registration Successfull",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,SecondActivity.class));
    }
}