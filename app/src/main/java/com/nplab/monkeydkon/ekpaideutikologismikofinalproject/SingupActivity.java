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
                        mDatabase.child("users").child(username).child("progress").child("classes").setValue(false);
                        mDatabase.child("users").child(username).child("progress").child("certificate").setValue(false);

                        mDatabase.child("users").child(username).child("certificateProgress").child("mistakes").setValue(0);

                        mDatabase.child("users").child(username).child("classesProgress").child("classes").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("getters").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("methods").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("oop").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("quiz").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("returnTypes").setValue(false);

                        mDatabase.child("users").child(username).child("classesProgress").child("classesfalse").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("gettersfalse").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("methodsfalse").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("oopfalse").setValue(false);
                        mDatabase.child("users").child(username).child("classesProgress").child("returntypesfalse").setValue(false);

                        mDatabase.child("users").child(username).child("classesProgress").child("mistakes").setValue(0);
                        mDatabase.child("users").child(username).child("classesProgress").child("pososto").setValue(0);

                        mDatabase.child("users").child(username).child("conceptsProgress").child("comments").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("input").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("intro").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("quiz").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("strings").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("variables").setValue(false);

                        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("inputfalse").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("introfalse").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("stringfalse").setValue(false);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("variablesfalse").setValue(false);

                        mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(0);
                        mDatabase.child("users").child(username).child("conceptsProgress").child("pososto").setValue(0);

                        mDatabase.child("users").child(username).child("ifsProgress").child("elseif").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("for").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("if").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("quiz").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("switch").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("while").setValue(false);

                        mDatabase.child("users").child(username).child("ifsProgress").child("elseiffalse").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("forfalse").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("iffalse").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("switchfalse").setValue(false);
                        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").setValue(false);

                        mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(0);
                        mDatabase.child("users").child(username).child("ifsProgress").child("pososto").setValue(0);

                        mDatabase.child("users").child(username).child("visited").child("classes").child("classes").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("classes").child("getters").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("classes").child("methods").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("classes").child("oop").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("classes").child("return").setValue(0);

                        mDatabase.child("users").child(username).child("visited").child("concepts").child("comments").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("concepts").child("input").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("concepts").child("intro").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("concepts").child("strings").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("concepts").child("variables").setValue(0);

                        mDatabase.child("users").child(username).child("visited").child("statements").child("elseif").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("statements").child("for").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("statements").child("if").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("statements").child("switch").setValue(0);
                        mDatabase.child("users").child(username).child("visited").child("statements").child("while").setValue(0);

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
        exitAppMessage.backMessage(SingupActivity.this, this, "You are about to exit. Are you sure?");
    }

    public void login(View view){
        startActivity(new Intent(SingupActivity.this, LoginActivity.class));
    }
}
