package com.example.temp;

import android.Manifest;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.permissioneverywhere.PermissionEverywhere;
import com.permissioneverywhere.PermissionResponse;
import com.permissioneverywhere.PermissionResultCallback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            String file_path=intent.getStringExtra("path_of_file");
            loadResultFromTxt(file_path);
        } catch (IOException e) {
            Log.d("TAG", "onCreate: "+e);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void loadResultFromTxt(String path) throws IOException {

        Log.d("TAG", "loadResultFromTxt: "+getExternalFilesDir(null).getAbsolutePath());
//        InputStream is=context.getContentResolver().openInputStream(Uri.fromFile(result_file));
        File result_file=new File("/storage/emulated/0/Android/data/com.example.temp/files/input_report.txt");
        FileInputStream fis=new FileInputStream(result_file);

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] line_split=line.split(": ",2);
            Log.d("TAG", "loadResultFromTxt: "+line);
        }
        fis.close();
    }
}
