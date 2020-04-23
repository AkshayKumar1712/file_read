package com.example.temp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String file_path=getIntent().getStringExtra("path_of_the_file");
        try {
            loadResultFromTxt(file_path);
        } catch (IOException e) {
            Log.d("TAG", "onCreate: "+e);
        }
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
