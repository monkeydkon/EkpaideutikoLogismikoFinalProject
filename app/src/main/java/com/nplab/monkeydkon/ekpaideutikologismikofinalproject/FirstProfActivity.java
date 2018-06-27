package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstProfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_prof);
    }

    public void questions(View view){
        startActivity(new Intent(FirstProfActivity.this, ProfActivity.class));
    }

    public void episkepsimotita(View view){
        startActivity(new Intent(FirstProfActivity.this, ProfEpiskepsimotitaActivity.class));

    }
}
