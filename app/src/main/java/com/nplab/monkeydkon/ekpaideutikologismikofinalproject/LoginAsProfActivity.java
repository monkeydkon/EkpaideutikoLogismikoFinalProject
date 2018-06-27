package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAsProfActivity extends AppCompatActivity {

    EditText editText3,editText4;
    Button button6;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_prof);

        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void login(View view){
        final String username = editText3.getText().toString().toLowerCase();
        final String password = editText4.getText().toString();

        if(username.equals("") || password.equals("")){
            Toast.makeText(this,"You left at least a field empty. Try again.",Toast.LENGTH_SHORT).show();
        }else{
            mDatabase.child("profs").child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        mDatabase.child("profs").child(username).child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.getValue().toString().equals(password)){

                                    Toast.makeText(getApplicationContext(),"You are now logged in.",Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(LoginAsProfActivity.this, FirstProfActivity.class));

                                }else{
                                    Toast.makeText(getApplicationContext(),"Wrong password. Try again.",Toast.LENGTH_SHORT).show();
                                    editText4.setText("");
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }else{
                        Toast.makeText(getApplicationContext(),"This username doesn't exist", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
