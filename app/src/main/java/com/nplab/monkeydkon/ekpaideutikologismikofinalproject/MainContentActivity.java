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

    ImageView learnBasicConcepts, learnIfAndLoops, learnArrays, learnClassesAndObjects, takeCertificate;

    private DatabaseReference mDatabase;

    String username;

    Boolean arraysProgress;
    Boolean conceptsProgress;
    Boolean cerificateProgress;
    Boolean statementsProgress;
    Boolean classesProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        learnBasicConcepts = findViewById(R.id.learnBasicConcepts);
        learnIfAndLoops = findViewById(R.id.learnIfAndLoops);
        learnArrays = findViewById(R.id.learnArrays);
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
                arraysProgress = (Boolean) dataSnapshot.child("arrays").getValue();
                classesProgress = (Boolean) dataSnapshot.child("classes").getValue();
                cerificateProgress = (Boolean) dataSnapshot.child("certificate").getValue();

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

                if(arraysProgress){
                    learnArrays.setImageDrawable(getResources().getDrawable(R.drawable.third_green));
                }else{
                    learnArrays.setImageDrawable(getResources().getDrawable(R.drawable.third_red));
                }

                if(classesProgress){
                    learnClassesAndObjects.setImageDrawable(getResources().getDrawable(R.drawable.fourth_green));
                }else{
                    learnClassesAndObjects.setImageDrawable(getResources().getDrawable(R.drawable.fourth_red));
                }

                if(cerificateProgress){
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
        //todo
    }

    public void ifStatementAndLoops(View view){
        //todo
    }

    public void arrays(View view){
        //todo
    }

    public void classesAndObjects(View view){
        //todo
    }

    public void certificate(View view){
        //todo
    }
}
