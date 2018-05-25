package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button loginBtn;

    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.login);

        signup = findViewById(R.id.signup);

        textView = findViewById(R.id.textView);

        textView.setAlpha(0f);

        textView.animate().alpha(1f).setDuration(1500);
    }

    public void login(View view){

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }

    public void signup(View view){

        startActivity(new Intent(MainActivity.this, SingupActivity.class));


    }

    public void logAsProf(View view){
        startActivity(new Intent(MainActivity.this, LoginAsProfActivity.class));
    }


    @Override
    public void onBackPressed() {
        ExitAppMessage exitAppMessage = new ExitAppMessage();
        exitAppMessage.backMessage(MainActivity.this, this, "You are about to exit. Are you sure?");
    }
}
