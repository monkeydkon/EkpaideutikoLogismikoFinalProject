package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstProfActivity extends AppCompatActivity {

    TextView logoutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_prof);

        logoutText = findViewById(R.id.logoutText);
    }

    public void questions(View view){
        startActivity(new Intent(FirstProfActivity.this, ProfActivity.class));
    }

    public void episkepsimotita(View view){
        startActivity(new Intent(FirstProfActivity.this, ProfEpiskepsimotitaActivity.class));

    }

    public void logout(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
