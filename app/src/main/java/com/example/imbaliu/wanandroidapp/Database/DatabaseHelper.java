package com.example.imbaliu.wanandroidapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.imbaliu.wanandroidapp.Bean.DataMain;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.Database
 * 文件名： DatabaseHelper
 * 创建者： LFY
 * 创建时间： 2019/1/2 16:11
 * 描述：   TODO
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String NOTEBOOK = "NoteBook.db";

    private Context context;
    public static final String CREATE_BOOK = "create table Note (id integer primary key autoincrement, author text,title text,date text,link text)";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(context, "创建数据库成功", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 添加数据
     */
    public static void addData(Context context, DataMain item) {
        DatabaseHelper dbHelper = new DatabaseHelper(context, DatabaseHelper.NOTEBOOK, null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
       for (DataMain dataMain:queryData(context)){
           if (dataMain.getTitle().equals(item.getTitle())) {
               return;
           }
       }
        ContentValues values = new ContentValues();
        values.put("author", item.getAuthor());
        values.put("title", item.getTitle());
        values.put("link", item.getLink());
        values.put("date", item.getNiceDate());
        db.insert("Note", null, values);
    }

    /**
     * 查询数据
     */
    public static List<DataMain> queryData(Context context) {
        DatabaseHelper dbhelper = new DatabaseHelper(context, "NoteBook.db", null, 1);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        List<DataMain> mainList = new ArrayList<>();

        Cursor cursor = db.query("Note", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                DataMain dataMain = new DataMain(cursor.getString(cursor.getColumnIndex("author")),
                        cursor.getString(cursor.getColumnIndex("link")), cursor.getString(cursor.getColumnIndex("date")), cursor.getString(cursor.getColumnIndex("title")));

                mainList.add(dataMain);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return mainList;
    }

    /**
     * 删除数据
     */
    public static void  deleteData(Context context,String title){
        DatabaseHelper dbhelper = new DatabaseHelper(context, "NoteBook.db", null, 1);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.delete("Note","title=?",new String[]{title});
    }

}
