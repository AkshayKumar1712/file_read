package com.example.temp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{"android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ__EXTERNAL_STORAGE"},200);
        Context context=getApplicationContext();
        Intent intent=new Intent(this,MyService.class);
        intent.putExtra("path_of_the_file","/storage/emulated/0/SMS Creator Reports/input_report.txt");
        startForegroundService(intent);
    }
}
