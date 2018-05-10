package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConceptsCommentsActivity extends AppCompatActivity {

    private static final String TAG = "ConceptsCommentsActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    Button done;

    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepts_comments);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        done = findViewById(R.id.done);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "single-line");
        adapter.addFragment(new Tab2Fragment(), "multi-line");
        adapter.addFragment(new Tab3Fragment(), "documentation");
        viewPager.setAdapter(adapter);
    }

    public void done(View view){
        Intent intent = new Intent(getApplicationContext(),ConceptCommentsTestActivitty.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }
}
