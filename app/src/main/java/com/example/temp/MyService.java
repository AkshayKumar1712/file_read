package com.example.temp;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String file_path=intent.getStringExtra("path_of_the_file");
        try {
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

    private void loadResultFromTxt(String path) throws IOException {


//        InputStream is=context.getContentResolver().openInputStream(Uri.fromFile(result_file));
        File result_file=new File(path);

        FileInputStream fis=new FileInputStream(result_file);

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] line_split=line.split(": ",2);
            Log.d("TAG", "loadResultFromTxt: "+line);
        }
    }
}
