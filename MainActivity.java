package com.example.database_dictionary_12_4;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity
{
    Button btnFind;
    TextView txtResult;
    EditText editText;
    Dictionary dic;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dic = new Dictionary(this);
        dic.copyDataBase();
        findViews();
        actionsInNeed();
    }




    void actionsInNeed()
    {
        btnFind.setOnClickListener(new View.OnClickListener()
        {
            String temp = editText.getText().toString();
            @Override
            public void onClick(View v)
            {
                if (temp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Box is Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    String temp2 = dic.readFromDataBase(editText.getText().toString());
                    Toast.makeText(MainActivity.this, temp2, Toast.LENGTH_SHORT).show();
                    txtResult.setText(temp2);
                }

            }
        });
    }

    void findViews()
    {
        btnFind = findViewById(R.id.btn_find_mainActivity_id);
        txtResult = findViewById(R.id.txt_result_mainActivity_id);
        editText = findViewById(R.id.edt_input_getter_mainActivity_id);
    }


}
