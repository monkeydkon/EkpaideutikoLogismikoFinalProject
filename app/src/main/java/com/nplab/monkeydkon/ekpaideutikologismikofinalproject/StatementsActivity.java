package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatementsActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;

    boolean elseifs;
    boolean fors;
    boolean ifs;
    boolean quiz;
    boolean whiles;
    boolean switches;

    String username;

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);


        cardView = findViewById(R.id.cardView);

        final RelativeLayout firstRelative = findViewById(R.id.firstRelative);
        final RelativeLayout secondRelative = findViewById(R.id.secondRelative);
        final RelativeLayout thirdRelative = findViewById(R.id.thirdRelative);
        final RelativeLayout fifthRelative = findViewById(R.id.fifthRelative);
        final RelativeLayout sixthRelative = findViewById(R.id.sixthRelative);
        final RelativeLayout seventhRelative = findViewById(R.id.seventhRelative);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("ifsProgress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                elseifs = (Boolean) dataSnapshot.child("elseif").getValue();
                fors = (Boolean) dataSnapshot.child("for").getValue();
                ifs = (Boolean) dataSnapshot.child("if").getValue();
                quiz = (Boolean) dataSnapshot.child("quiz").getValue();
                whiles = (Boolean) dataSnapshot.child("while").getValue();
                switches = (Boolean) dataSnapshot.child("switch").getValue();

                if(ifs){
                    firstRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(elseifs){
                    secondRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(switches){
                    thirdRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(whiles){
                    fifthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(fors){
                    sixthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(quiz){
                    seventhRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    
    public void ifs(View view){
        // TODO: 16/5/2018  
    }
    
    public void elseifs(View view){
        // TODO: 16/5/2018  
    }
    
    public void switches(View view){
        // TODO: 16/5/2018  
    }
    
    public void whiles(View view){
        // TODO: 16/5/2018  
    }
    
    public void fors(View view){
        // TODO: 16/5/2018
    }
    
    public void quiz(View view){
        // TODO: 16/5/2018  
    }
}
