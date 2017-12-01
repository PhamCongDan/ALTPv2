package nnc.tlcn.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dan Pham on 12/02/2017.
 */

public class Database extends SQLiteOpenHelper {

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //truy van ko tra kqt qua create insert update delete
    public void QueryData(String query){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(query);
    }
    //truy van co tra ket qua select
    public Cursor GetData(String query){
        SQLiteDatabase db=getWritableDatabase();
        return db.rawQuery(query,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
