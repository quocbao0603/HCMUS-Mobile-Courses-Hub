package com.example.courseshub.DB;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Tag for LogCat
    private static String TAG = "DataBaseHelper";
    //Tên cơ sở dữ liệu
    public  static String DB_NAME = "coursehub_data.db";
    // Path lưu Database
    public static String DB_PATH;

    private static int version = 1;
    private SQLiteDatabase _dataBase;
    private final Context _context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, version);
        // Đường dẫn ở phiên bài API >= 17 có sự thay đổi nên cần phải xét thêm
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        Log.e(TAG, "createDatabase ne");
        this._context = context;
    }

    public void createDataBase(){
        // Nếu database chưa tồn tồi, ta copy từ asset
        boolean isDataBaseExist = checkDataBase();
        //if (!isDataBaseExist){
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        //}
        //else Log.e(TAG, "database Exist!");
    }

    //Copy Database from my assets
    private void copyDataBase() throws IOException {
        InputStream inputStream = _context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream outputStream = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int  length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
        Log.e(TAG, "createDatabase database copy");
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        _dataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return _dataBase != null;
    }

    @Override
    public synchronized void close() {
        if (_dataBase != null)
            _dataBase.close();
        super.close();
    }

    public void getAllDiscussion(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String SQL = "SELECT * FROM Discussion";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null){

            if (cursor.getCount() > 0){
                cursor.moveToFirst();

                while(!cursor.isAfterLast()){
                    String id_discussion = cursor.getString(0);
                    String id_course = cursor.getString(1);
                    String information = cursor.getString(2);
                    //System.out.println(id + name);
                    Log.e(TAG, id_discussion);
                    Log.e(TAG, id_course);
                    Log.e(TAG, information);
                    cursor.moveToNext();
                }
                cursor.close();
            }
            else {
                Log.e(TAG, "Traversal 1");
            }
        }
        else Log.e(TAG, "Query Fail!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
