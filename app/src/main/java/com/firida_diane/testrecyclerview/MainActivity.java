package com.firida_diane.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {
    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    private ArrayList<Planete> planetes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        planetes=new ArrayList<Planete>();
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        /*RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, R.drawable.divider);
        mRecyclerView.addItemDecoration(itemDecoration);*/

    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }


    private ArrayList<Planete> getDataSource() {

        Planete p1=new Planete("Mercure","4900",R.drawable.mercure);
        Planete p2=new Planete("Venus","12000",R.drawable.venus);
        Planete p3=new Planete("Terre","12800",R.drawable.terre);
        Planete p4=new Planete("Mars","6800",R.drawable.venus);
        Planete p5=new Planete("Jupiter","144000",R.drawable.mercure);
        Planete p6=new Planete("Saturne","120000",R.drawable.neptune);
        Planete p7=new Planete("Uranus","52000",R.drawable.terre);
        Planete p8=new Planete("Nepturne","50000",R.drawable.neptune);
        Planete p9=new Planete("Pluton","2300",R.drawable.mercure);
        planetes.add(p1);
        planetes.add(p2);
        planetes.add(p3);
        planetes.add(p4);
        planetes.add(p5);
        planetes.add(p6);
        planetes.add(p7);
        planetes.add(p8);
        planetes.add(p9);

        return planetes;
    }

    @Override
    public void clicSurRecyclerItem(int position, View v) {
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();
    }
}