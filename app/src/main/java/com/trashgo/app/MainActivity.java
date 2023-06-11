package com.trashgo.app;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.trashgo.app.fragment.CommunityFragment;
import com.trashgo.app.fragment.ComuWriteFragment;
import com.trashgo.app.fragment.MapsFragment;
import com.trashgo.app.fragment.MyPageFragment;
import com.trashgo.app.fragment.TreeFragment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//주원

/**
 * bottomNavigation(하단 메뉴바) 적용 - pkdgood
 */
public class MainActivity extends AppCompatActivity {
    private Fragment treeFragment, mapsFragment, communityFragment, myPageFragment, comuwriteFragment;

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
            intent = new Intent();
            if (!notificationManager.isNotificationPolicyAccessGranted()) {
                intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
//                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivity(intent);
            }
        }


        bottomNavigationView = findViewById(R.id.bottomnavi);
        frameLayout = findViewById(R.id.framelayout);

        treeFragment = new TreeFragment();
        mapsFragment = new MapsFragment();
        communityFragment = new CommunityFragment();
        myPageFragment = new MyPageFragment();
        comuwriteFragment = new ComuWriteFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, treeFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
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

    public void ploggingStartClick(View v) {
        if (Build.VERSION.SDK_INT >= 30){
            if (!Environment.isExternalStorageManager()){
                Intent intent = new Intent(MainActivity.this, PloggingActivity.class);
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 1);
            }
        } else {
            Intent intent = new Intent(MainActivity.this, PloggingActivity.class);
//                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
            startActivityForResult(intent, 1);
        }

        Log.println(Log.INFO, "MAIN ACTIVITY", "HI");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            Log.println(Log.INFO, "MAIN ACTIVITY", "CALLBACK");
        }

//        String dd = "{\"latLngList\":[{\"latitude\":36.6257,\"logitude\":127.4517},{\"latitude\":36.6256,\"logitude\":127.4542},{\"latitude\":36.6276,\"logitude\":127.4589}],\"name\":null,\"picList\":[],\"ploggingDt\":null}";

        String dd = null;
        try {
            FileInputStream infs = openFileInput("plogging.json");
            byte[] txt = new byte[1024];
            infs.read(txt);
            infs.close();
            dd = (new String(txt)).trim();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Bundle bundle = new Bundle();
        bundle.putString("ploggingData", dd);
        mapsFragment = new MapsFragment();
        mapsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, mapsFragment).commit();

    }
}