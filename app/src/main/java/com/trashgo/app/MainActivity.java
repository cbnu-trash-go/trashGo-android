package com.trashgo.app;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.trashgo.app.fragment.CommunityFragment;
import com.trashgo.app.fragment.ComuWriteFragment;
import com.trashgo.app.fragment.MapsFragment;
import com.trashgo.app.fragment.MyPageFragment;
import com.trashgo.app.fragment.TreeFragment;

//주원

/**
 * bottomNavigation(하단 메뉴바) 적용 - pkdgood
 */
public class MainActivity extends AppCompatActivity {
    private Fragment treeFragment, mapsFragment, communityFragment, myPageFragment, comuwriteFragment, CommunityFragment;

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sohenney Loading 화면 띄우기
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);

        // sohenney '방해 금지' 모드 권한 확인
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (!notificationManager.isNotificationPolicyAccessGranted()) {
                intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                startActivity(intent);
            }
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavi);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);

        treeFragment = new TreeFragment();
        mapsFragment = new MapsFragment();
        communityFragment = new CommunityFragment();
        myPageFragment = new MyPageFragment();
        comuwriteFragment = new ComuWriteFragment();
        CommunityFragment = new CommunityFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, treeFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navi_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, treeFragment).commit();
                        return true;
                    case R.id.navi_2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, mapsFragment).commit();
                        return true;
                    case R.id.navi_3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, communityFragment).commit();
                        return true;
                    case R.id.navi_4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myPageFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
    /**
     *  fragment->fragment 이동을 하고 싶으면 밑에 인덱스 차례대로 추가해서 넣으세요
     *  by dotom
     */
    public void fragmentChange(int index){
        if(index == 1){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, comuwriteFragment).commit();
        }else if(index == 2){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, CommunityFragment).commit();
        }

    }

    public void mytreeClick(View v) {
        Intent intent = new Intent(MainActivity.this, MyploggingdataActivity.class);
        startActivity(intent);
    }
    public void loginClick(View v) {
        Intent intent = new Intent(MainActivity.this, activity_login.class);
        startActivity(intent);
    }
    public void profileClick(View v) {
        Intent intent = new Intent(MainActivity.this, activity_profile.class);
        startActivity(intent);
    }
    public void notificationClick(View v) {
        Intent intent = new Intent(MainActivity.this, activity_notification.class);
        startActivity(intent);
    }
    public void noticeClick(View v) {
        Intent intent = new Intent(MainActivity.this, NoticeUpdateActivity.class);
        startActivity(intent);
    }
    public void withdrawalClick(View v) {
        Intent intent = new Intent(MainActivity.this, activity_withdrawal.class);
        startActivity(intent);
    }
}