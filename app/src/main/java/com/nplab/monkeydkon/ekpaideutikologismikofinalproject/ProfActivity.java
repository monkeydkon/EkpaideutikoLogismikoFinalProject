package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfActivity extends AppCompatActivity {

    ListView listView;

    DatabaseReference mDatabase;

    ArrayList<String> questions = new ArrayList<>();

    ArrayList<String> questionsChapters = new ArrayList<>();

    ArrayList<String> questionsChaptersNumbers = new ArrayList<>();

    ArrayList<String> whichNumber = new ArrayList<>();

    String chapter;

    String which;

    String finalChosen;

    String first,second,third,question,correct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        listView = findViewById(R.id.listView);

        mDatabase.child("questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    questions.add(ds.getKey());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,questions);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       chapter = questions.get(position);
                       mDatabase.child("questions").child(chapter).addValueEventListener(new ValueEventListener() {
                           @Override
                           public void onDataChange(DataSnapshot dataSnapshot) {
                               for(DataSnapshot ds : dataSnapshot.getChildren()){
                                   questionsChapters.add(ds.getKey());
                               }
                               ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,questionsChapters);
                               listView.setAdapter(arrayAdapter);

                               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                   @Override
                                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                       which = questionsChapters.get(position);
                                       mDatabase.child("questions").child(chapter).child(which).addValueEventListener(new ValueEventListener() {
                                           @Override
                                           public void onDataChange(DataSnapshot dataSnapshot) {
                                               for(DataSnapshot ds : dataSnapshot.getChildren()){
                                                   questionsChaptersNumbers.add(ds.getKey());
                                               }
                                               ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,questionsChaptersNumbers);
                                               listView.setAdapter(arrayAdapter);



                                               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                   @Override
                                                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                       finalChosen = questionsChaptersNumbers.get(position);
                                                       mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("answers").addValueEventListener(new ValueEventListener() {
                                                           @Override
                                                           public void onDataChange(DataSnapshot dataSnapshot) {
                                                               first = dataSnapshot.child("first").getValue().toString();
                                                               second = dataSnapshot.child("second").getValue().toString();
                                                               third = dataSnapshot.child("third").getValue().toString();
                                                               correct = dataSnapshot.child("correct").getValue().toString();
                                                           }

                                                           @Override
                                                           public void onCancelled(DatabaseError databaseError) {

                                                           }
                                                       });

                                                       mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("question").addValueEventListener(new ValueEventListener() {
                                                           @Override
                                                           public void onDataChange(DataSnapshot dataSnapshot) {
                                                               question = dataSnapshot.getValue().toString();

                                                               Intent intent = new Intent(getApplicationContext(),ProfChangeActivity.class);

                                                               intent.putExtra("question", question);
                                                               intent.putExtra("first", first);
                                                               intent.putExtra("second", second);
                                                               intent.putExtra("third", third);
                                                               intent.putExtra("correct",correct);
                                                               intent.putExtra("chapter", chapter);
                                                               intent.putExtra("which", which);
                                                               intent.putExtra("finalChosen", finalChosen);


                                                               startActivity(intent);
                                                           }

                                                           @Override
                                                           public void onCancelled(DatabaseError databaseError) {

                                                           }
                                                       });





                                                   }




                                               });


                                           }

                                           @Override
                                           public void onCancelled(DatabaseError databaseError) {

                                           }
                                       });
                                   }
                               });
                           }

                           @Override
                           public void onCancelled(DatabaseError databaseError) {

                           }
                       });
                    }
                });
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
