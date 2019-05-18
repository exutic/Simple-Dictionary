package com.example.database_dictionary_12_4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Dictionary extends SQLiteOpenHelper
{

    public static final String DB_NAME = "DicDb";
    public static final int DB_VERSION = 1;
    public static final String REAL_PATH = "/data/data/com.example.database_dictionary_12_4.packagename/databases/";
    private Context context;


    public Dictionary(Context context)
    {
        super(context,DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  String  readFromDataBase(String name)
    {
        String whereDataBase = " select meaning from TranslateWord where " +name+ " = 'dog' ";
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery(whereDataBase,null);

        return cursor.toString();
    }

    public void copyDataBase() throws IOException
    {

            //Open your local db as the input stream
            InputStream inputStream = context.getAssets().open(DB_NAME);  // Done it

            // masire dp ke az 2 ta string tashkil shode
            String outFileName = REAL_PATH + DB_NAME; // Done it

            //db khali ro be onvane output stream baz mikonim
            OutputStream outputStream = new FileOutputStream(outFileName); // Done it

            //transfer bytes from the inputFile to the outputFile
            byte[] byteArr = new byte[512];
            int length;
            while ((length = inputStream.read(byteArr)) > 0) {
                outputStream.write(byteArr, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            //Close the streams  // Know it from OOP


    }

    public boolean isDbHere()
    {
        boolean flag = false;

        try
        {
            String string = REAL_PATH+DB_NAME;
            File file = new File(string);
            flag=file.exists();
        }
        catch (SQLiteException e)
        {
            e.getStackTrace();
        }
        return flag;
    }
}
