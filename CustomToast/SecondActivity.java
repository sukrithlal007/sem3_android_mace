package com.example.customtoast;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        Button prevBtn = (Button) findViewById(R.id.prevBtn);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LoginLogs","Onclick called");
                String username,password;
                Toast toast = new Toast(SecondActivity.this);

                username = ((EditText) findViewById(R.id.username)).getText().toString();
                password = ((EditText) findViewById(R.id.password)).getText().toString();

                SharedPreferences sp = getSharedPreferences("MyInfo",MODE_PRIVATE);

                if(username.equals(sp.getString("username","")) &&
                        password.equals(sp.getString("password",""))){

                    Log.d("LoginLogs","Credentials matched");

                    LayoutInflater Lin = getLayoutInflater();
                    View appear = Lin.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout) );

                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(appear);
                    toast.show();

                }else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}