package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SingupActivity extends AppCompatActivity {

    EditText userEditText, passEditText, nameEditText;
    Button registerButton;
    TextView textView2;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        userEditText = findViewById(R.id.userEditText);
        passEditText = findViewById(R.id.passEditText);
        nameEditText = findViewById(R.id.nameEditText);
        textView2 = findViewById(R.id.textView2);

        registerButton = findViewById(R.id.registerButton);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void register(View view){

        final String username = userEditText.getText().toString().toLowerCase();
        final String password = passEditText.getText().toString();
        final String name = nameEditText.getText().toString();

        if (username.equals("") || password.equals("") || name.equals("")){
            Toast.makeText(this,"You left at least a field empty. Please, try again", Toast.LENGTH_SHORT).show();
        }else{
            mDatabase.child("users").child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        Toast.makeText(getApplicationContext(),"This username is being used. Try again with a new one",Toast.LENGTH_SHORT).show();
                        userEditText.setText("");
                        passEditText.setText("");
                        nameEditText.setText("");
                    }else{
                        mDatabase.child("users").child(username).child("password").setValue(password);
                        mDatabase.child("users").child(username).child("name").setValue(name);
                        mDatabase.child("users").child(username).child("progress").child("concepts").setValue(false);
                        mDatabase.child("users").child(username).child("progress").child("statements").setValue(false);
                        mDatabase.child("users").child(username).child("progress").child("arrays").setValue(false);
                        mDatabase.child("users").child(username).child("progress").child("classes").setValue(false);
                        mDatabase.child("users").child(username).child("progress").child("certificate").setValue(false);
                        Toast.makeText(getApplicationContext(),"You successfully signed up",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        ExitAppMessage exitAppMessage = new ExitAppMessage();
        exitAppMessage.backMessage(SingupActivity.this, this);
    }

    public void login(View view){
        startActivity(new Intent(SingupActivity.this, LoginActivity.class));
    }
}
