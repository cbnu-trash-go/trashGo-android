package com.trashgo.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.trashgo.app.fragment.Notice1Fragment;

// sohenney activity_noticeupdate.java 추가
public class activity_noticeupdate extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticesupdates);

        Button btnNotice1 = (Button) findViewById(R.id.btnnotice1);
        btnNotice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Notice1Fragment notice1Fragment = Notice1Fragment.newInstance("param1", "param2");
                fragmentTransaction.replace(R.id.noticeupdatemain, notice1Fragment);
                fragmentTransaction.commit();
                Log.d("MyApp", "버튼이 클릭되었습니다.");
            }
        });
    }
}
