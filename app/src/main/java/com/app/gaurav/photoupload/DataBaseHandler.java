package com.app.gaurav.photoupload;

/**
 * Created by gaurav on 14/03/16.
 */

        import java.util.ArrayList;
        import java.util.List;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION=1;
    public static String DATABASE_NAME = "recordTable";
    public static String TABLE_NAME = "records";

    public static String Column_1_Name = "name";
    public static String Column_2_Name = "image_adr";
    public static String Column_3_Name = "group_name";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + Column_1_Name + " TEXT," + Column_2_Name + " TEXT,"
                + Column_3_Name + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void addRecords(SqlEntry entry){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Column_1_Name, entry.getName());
        values.put(Column_2_Name, entry.getImage());
        values.put(Column_3_Name,entry.getGroup());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<SqlEntry> getAllRecordss() {
        List<SqlEntry> RecordList = new ArrayList<SqlEntry>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SqlEntry entry = new SqlEntry(cursor.getString(0),cursor.getString(1),cursor.getString(2));

                RecordList.add(entry);
            } while (cursor.moveToNext());
        }

        return RecordList;
    }


}