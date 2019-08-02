package com.example.gmailrecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Inter {

    private ArrayList<String> arrayList = new ArrayList<>();
    private RecyclerView rvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList=findViewById(R.id.rvList);
        for(int i=0; i<10;i++)
            arrayList.add("1"+i+":"+((i+2)/2)+"0");

        GmailAdapter adapter = new GmailAdapter(arrayList,this::call);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);
    }


    @Override
    public void call(String s) {

    }
}
