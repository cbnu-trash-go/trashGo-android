package com.trashgo.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.trashgo.app.fragment.FirstFragment;
import com.trashgo.app.fragment.SecondFragment;
import com.trashgo.app.fragment.TreeFragment;

//주원

/**
 * bottomNavigation(하단 메뉴바) 적용 - pkdgood
 */
public class MainActivity extends AppCompatActivity {
    private Fragment firstFragment, secondFragment, treeFragment;

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sohenney '방해 금지' 모드 권한 확인
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            if (!notificationManager.isNotificationPolicyAccessGranted()) {
//                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
//                startActivity(intent);
//            }
//        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavi);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        treeFragment = new TreeFragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, treeFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navi_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, firstFragment).commit();
                        return true;
                    case R.id.navi_2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, secondFragment).commit();
                        return true;
                    case R.id.navi_3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, treeFragment).commit();
                        return true;
                }
                return false;
            }
        });

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