package com.example.sqlitedbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static
    {
        System.loadLibrary("native-library");
    }

    AppCompatButton btnInsert,btnCreate;
    String db_path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise Views
        initialiseViews();

        db_path = MainActivity.this.getDatabasePath("Country").getPath();

        NativeLibrary nativeLibrary = new NativeLibrary();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               boolean success = nativeLibrary.createDb(db_path);
               if(success){
                   Toast.makeText(getApplicationContext()," Db Created Successfully",Toast.LENGTH_LONG).show();
               }else {
                   Toast.makeText(getApplicationContext(),"Db Creation Failed",Toast.LENGTH_LONG).show();
               }

            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success = nativeLibrary.insertData(db_path);
                if(success){
                    Toast.makeText(getApplicationContext()," Data Inserted Successfully",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Db Insertion Failed",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void initialiseViews() {

        btnCreate= findViewById(R.id.btnCreate);
        btnInsert= findViewById(R.id.btnInsert);
    }
}