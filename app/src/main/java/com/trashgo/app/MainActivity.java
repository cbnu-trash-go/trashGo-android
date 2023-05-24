package com.trashgo.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

//주원

public class MainActivity extends AppCompatActivity {
    ImageButton imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = (ImageButton) findViewById(R.id.imageViewtree); //코드로 뷰를불러옴 직접 리스너를 등록함


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyploggingdataActivity.class);
                startActivity(intent);
                // 버튼 동작 설정
            }
        };
        imageView1.setOnClickListener(listener);
    }
}