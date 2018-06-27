package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfEpiskepsimotitaActivity extends AppCompatActivity {

    ListView listView;

    DatabaseReference mDatabase;

    ArrayList<String> users = new ArrayList<>();

    ArrayList<String> chapters = new ArrayList<>();

    ArrayList<String> subchapters = new ArrayList<>();



    String who,which;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_episkepsimotita);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        listView = findViewById(R.id.listView);

        mDatabase.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    users.add(ds.getKey());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,users);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        who = users.get(i);
                        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                        intent.putExtra("whoIsLoggedIn", who);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
