package com.trashgo.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

public class PloggingActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStop;
    Location location;

    final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plogging);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        chronometer = findViewById(R.id.stopWatch);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

        btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(view -> stopPlogging());

        location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {

            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();

            txtResult.setText("위치정보 : " + provider + "\n" +
                    "위도 : " + longitude + "\n" +
                    "경도 : " + latitude + "\n" +
                    "고도  : " + altitude);

        }

    private void stopPlogging() {
        chronometer.stop();
        Handler handler = new Handler();
        handler.postDelayed(() -> finish(), 700);
    }
}