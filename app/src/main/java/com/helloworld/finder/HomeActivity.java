package com.helloworld.finder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.DemoAdapter;
import models.Demo;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Demo> demoList = new ArrayList<>();

        demoList.add(new Demo("Basic Map", MapsActivity.class));
        demoList.add(new Demo("Partial Map", PartialMapsActivity.class));
        demoList.add(new Demo("UI Map", UIMapsActivity.class));
        demoList.add(new Demo("Location Map", LocationsMapsActivity.class));


        DemoAdapter adapter = new DemoAdapter(demoList, this);

        RecyclerView rvDemos = findViewById(R.id.rvDemos);

        rvDemos.setAdapter(adapter);

        rvDemos.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        rvDemos.setLayoutManager(manager);

    }
}