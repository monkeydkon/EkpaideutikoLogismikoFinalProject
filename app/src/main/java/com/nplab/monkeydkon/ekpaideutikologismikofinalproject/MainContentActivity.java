package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainContentActivity extends AppCompatActivity {

    ImageView learnBasicConcepts, learnIfAndLoops,learnClassesAndObjects, takeCertificate;

    private DatabaseReference mDatabase;

    String username;

    Boolean conceptsProgress;
    Boolean certificateProgress;
    Boolean statementsProgress;
    Boolean classesProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        learnBasicConcepts = findViewById(R.id.learnBasicConcepts);
        learnIfAndLoops = findViewById(R.id.learnIfAndLoops);
        learnClassesAndObjects = findViewById(R.id.learnClassesAndObjects);
        takeCertificate = findViewById(R.id.takeCertificate);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("progress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                conceptsProgress = (Boolean) dataSnapshot.child("concepts").getValue();
                statementsProgress = (Boolean) dataSnapshot.child("statements").getValue();
                classesProgress = (Boolean) dataSnapshot.child("classes").getValue();
                certificateProgress = (Boolean) dataSnapshot.child("certificate").getValue();

                if(conceptsProgress){
                    learnBasicConcepts.setImageDrawable(getResources().getDrawable(R.drawable.first_green));
                }else{
                    learnBasicConcepts.setImageDrawable(getResources().getDrawable(R.drawable.first_red));
                }

                if(statementsProgress){
                    learnIfAndLoops.setImageDrawable(getResources().getDrawable(R.drawable.second_green));
                }else{
                    learnIfAndLoops.setImageDrawable(getResources().getDrawable(R.drawable.second_red));
                }


                if(classesProgress){
                    learnClassesAndObjects.setImageDrawable(getResources().getDrawable(R.drawable.fourth_green));
                }else{
                    learnClassesAndObjects.setImageDrawable(getResources().getDrawable(R.drawable.fourth_red));
                }

                if(certificateProgress){
                    takeCertificate.setImageDrawable(getResources().getDrawable(R.drawable.fifth_green));
                }else{
                    takeCertificate.setImageDrawable(getResources().getDrawable(R.drawable.fifth_red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void basicConcepts(View view){
        Intent intent = new Intent(getApplicationContext(),BasicConceptsActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }

    public void ifStatementAndLoops(View view){
        if(!conceptsProgress){
            Toast.makeText(this, "You first have to complete all the previous chapters.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),StatementsActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }

    public void classesAndObjects(View view){
        if(!statementsProgress){
            Toast.makeText(this, "You first have to complete all the previous chapters.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),ClassesActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }

    public void certificate(View view){
        if(!classesProgress){
            Toast.makeText(this, "You first have to complete all the previous chapters.", Toast.LENGTH_SHORT).show();
        }else{
            //todo
        }
    }

    @Override
    public void onBackPressed() {

    }
}
