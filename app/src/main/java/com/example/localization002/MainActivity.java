package com.example.localization002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView nameText,fatherText,collegeText,semisterText,technologyText,internyText,phoneText;
    String language;
    Button riyadh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText=findViewById(R.id.nameID);
        fatherText=findViewById(R.id.fatherNameID);
        collegeText=findViewById(R.id.collegeID);
        semisterText=findViewById(R.id.semesterID);
        technologyText=findViewById(R.id.technologyID);
        internyText=findViewById(R.id.internyID);
        phoneText=findViewById(R.id.phoneID);
        riyadh=findViewById(R.id.riyadhBtnID);

        ConstraintLayout constraintLayout=findViewById(R.id.mainLayoutID);
        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


        riyadh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
              startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){

            case R.id.english:
                language="en";
                setlocal(language);
                Toast.makeText(getApplicationContext(), "You are elect English language", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.bangla:
                language="bn";
                setlocal(language);
                Toast.makeText(getApplicationContext(),"You are elect Bangla language", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.hindi:
                language="hi";
                setlocal(language);
                Toast.makeText(getApplicationContext(),"You are elect hindi language", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.japanis:
                language="ja";
                setlocal(language);
                Toast.makeText(getApplicationContext(),"You are elect japanis language", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.urdu:
                language="ur";
                setlocal(language);
                Toast.makeText(getApplicationContext(),"You are elect urdu language", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setlocal(String language){

        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, displayMetrics);
        onConfigurationChanged(configuration);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        nameText.setText(R.string.name);
        fatherText.setText(R.string.fadar_name);
        collegeText.setText(R.string.college);
        semisterText.setText(R.string.semister);
        technologyText.setText(R.string.technology);
        internyText.setText(R.string.interny);
        phoneText.setText(R.string.phone);
        riyadh.setText(R.string.riyadh);


    }
}