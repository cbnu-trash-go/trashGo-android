package com.trashgo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
/*by dotom*/
public class MyploggingdataActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<ploggingDataRecyclerViewItem> mList;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myploggingdata);

        firstInit();

        for(int i=0;i<5;i++){
            addItem("iconName", "dotom" + i);
        }

        mRecyclerViewAdapter = new RecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void firstInit(){
        mRecyclerView = (RecyclerView) findViewById(R.id.pdRecyclerView);
        mList = new ArrayList<>();
    }

    public void addItem(String imgName, String mainText){
        ploggingDataRecyclerViewItem item = new ploggingDataRecyclerViewItem();

        item.setImgName(imgName);
        item.setDate(mainText);

        mList.add(item);
    }
}