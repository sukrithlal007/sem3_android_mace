package com.example.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.implicit_intent.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent,chooser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openImplicitIntent(View view) {
        if(view.getId() == R.id.mapBtn){
            //Code to open map here
            intent = new Intent(intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:10.067,76.869"));
            chooser = intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);
        }
        if(view.getId() == R.id.playstoreBtn){
            //Code to open playstore here
            intent =new Intent(intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.king.candycrushsaga"));
            startActivity(intent);
        }

        if(view.getId() == R.id.mailBtn){
            intent = new Intent(intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto"));
            String to [] = {"sukrithlal007@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"from emulator");
            intent.setType("message/rfc822");
            chooser=intent.createChooser(intent,"email application");
            startActivity(chooser);


        }
    }
}