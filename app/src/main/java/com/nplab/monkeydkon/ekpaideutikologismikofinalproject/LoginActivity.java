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

public class LoginActivity extends AppCompatActivity {

    EditText editText,editText2;
    TextView textView3;

    Button lgnBTN;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView3 = findViewById(R.id.textView3);

        lgnBTN = findViewById(R.id.lgnBTN);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void login(View view){
        final String username = editText.getText().toString().toLowerCase();
        final String password = editText2.getText().toString();

        if(username.equals("") || password.equals("")){
            Toast.makeText(this,"You left at least a field empty. Try again.",Toast.LENGTH_SHORT).show();
        }else{
            mDatabase.child("users").child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        mDatabase.child("users").child(username).child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.getValue().toString().equals(password)){

                                    Toast.makeText(getApplicationContext(),"You are now logged in.",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(),MainContentActivity.class);
                                    intent.putExtra("whoIsLoggedIn", username);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getApplicationContext(),"Wrong password. Try again.",Toast.LENGTH_SHORT).show();
                                    editText2.setText("");
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

    @Override
    public void onBackPressed() {
        ExitAppMessage exitAppMessage = new ExitAppMessage();
        exitAppMessage.backMessage(LoginActivity.this, this, "You are about to exit. Are you sure?");
    }

    public void signup(View view){
        startActivity(new Intent(LoginActivity.this, SingupActivity.class));

    }
}
