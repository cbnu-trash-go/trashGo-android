package com.trashgo.app;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

//주원

public class MainActivity extends AppCompatActivity {
    ImageButton imageView1;
    ImageView rankTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sohenney '방해 금지' 모드 권한 확인
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (!notificationManager.isNotificationPolicyAccessGranted()) {
                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                startActivity(intent);
            }
        }

        //imageView1 = (ImageButton) findViewById(R.id.imageViewtree); //코드로 뷰를불러옴 직접 리스너를 등록함
        //rankTap = (ImageView) findViewById(R.id.rankTap);


        /* xml에서 onclick연결로 변경
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyploggingdataActivity.class);
                startActivity(intent);
                // 버튼 동작 설정
            }
        };
        imageView1.setOnClickListener(listener);
        */

    }
    public void mytreeClick(View v) {
        Intent intent = new Intent(MainActivity.this, MyploggingdataActivity.class);
        startActivity(intent);
    }
    public void mypageClick(View v) {
        Intent intent = new Intent(MainActivity.this, activity_mypage.class);
        startActivity(intent);
    }
}