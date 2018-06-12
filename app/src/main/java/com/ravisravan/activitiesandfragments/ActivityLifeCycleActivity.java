package com.ravisravan.activitiesandfragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ActivityLifeCycleActivity extends AppCompatActivity {

    static ArrayList<String> lifeCycleMethodNamesArrayList;
    final String ONCREATE = "onCreate()";
    final String ONSTART = "onStart()";
    final String ONRESUME = "onResume()";
    final String ONRESTART = "onRestart()";
    final String ONPAUSE = "onPause()";
    final String ONSTOP = "onStop()";
    final String ONDESTROY = "onDestroy()";
    final String ONSAVEINSTANCESTATE = "onSaveInstaneState()";
    final String ONRESTOREINSTANCESTATE = "onRestoreInstanceState()";
    static int lifecycleMethodCount = 0;
    RecyclerView lifecycle_recycler_view;
    LifeCycleRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        if (lifeCycleMethodNamesArrayList == null)
            lifeCycleMethodNamesArrayList = new ArrayList<String>();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONCREATE + " called position " + lifecycleMethodCount);
        lifecycle_recycler_view = findViewById(R.id.lifecycle_recycler_view);
        mAdapter = new LifeCycleRecyclerViewAdapter(lifeCycleMethodNamesArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lifecycle_recycler_view.setLayoutManager(mLayoutManager);
        lifecycle_recycler_view.setItemAnimator(new DefaultItemAnimator());
        lifecycle_recycler_view.setAdapter(mAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAdapter.notifyDataSetChanged();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLifeCycleActivity.this, SimpleActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONSTART + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONRESUME + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONRESTART + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONPAUSE + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONSTOP + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONDESTROY + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONRESTOREINSTANCESTATE + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleMethodCount++;
        lifeCycleMethodNamesArrayList.add(ONSAVEINSTANCESTATE + " called position " + lifecycleMethodCount);
        mAdapter.notifyDataSetChanged();
    }
}
