package com.example.herexamenmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ItemAdapter Adapter;
    private final LinkedList<Integer> testList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList(100);

        RecyclerView testRecycler = findViewById(R.id.recycler);
        Adapter = new ItemAdapter(this, testList);
        testRecycler.setAdapter(Adapter);
        testRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateList (int max){
        for (int i = 1; i<=max; i++){
            testList.add(i);
        }
    }
}