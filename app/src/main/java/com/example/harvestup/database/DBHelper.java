package com.example.harvestup.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "PondData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table PondDetails(pondName TEXT primary key, pondlayout TEXT,timeStamp TEXT)");
        db.execSQL("create Table PondSectionDetails(pondSection TEXT  primary key,pondName TEXT, pondSecNum TEXT,size INTEGER, care TEXT, fishType TEXT, totalFishCapacity INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists PondDetails");
        db.execSQL("drop Table if exists PondSectionDetails");
        onCreate(db);
    }

    public Boolean insertPondDetails(String pondName, String pondLayout, String timeStamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pondName", pondName);
        contentValues.put("pondLayout", pondLayout);
        contentValues.put("timeStamp", timeStamp);
        long result = db.insert("PondDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updatePondDetails(String pondName, String pondLayout) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pondLayout", pondLayout);
        Cursor cursor = db.rawQuery("Select * from PondDetails where pondName = ? ", new String[]{pondName});
        if (cursor.getCount() > 0) {
            long result = db.update("PondDetails", contentValues, "pondName=?", new String[]{pondName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletePondDetails(String pondName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from PondDetails where pondName = ? ", new String[]{pondName});
        if (cursor.getCount() > 0) {
            long result = db.delete("PondDetails", "pondName=?", new String[]{pondName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from PondDetails", null);
        return cursor;
    }

    public Cursor getPondDatabyID(String pondName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select pondName, pondLayout, Timestamp from PondDetails where pondName = ?", new String[]{pondName});
        return cursor;
    }

    public Boolean insertSectionDetails(String pondSection, String pondName, String pondSecNum, int size, String care, String fishType, double totalFishCapacity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pondSection", pondSection);
        contentValues.put("pondName", pondName);
        contentValues.put("pondSecNum", pondSecNum);
        contentValues.put("size", size);
        contentValues.put("care", care);
        contentValues.put("fishType", fishType);
        contentValues.put("totalFishCapacity", totalFishCapacity);
        long result = db.insert("PondSectionDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateSectionDetails(String pondSection, int size, String care, String fishType, int totalFishCapacity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pondSection", pondSection);
        contentValues.put("size", size);
        contentValues.put("care", care);
        contentValues.put("fishType", fishType);
        contentValues.put("totalFishCapacity", totalFishCapacity);
        Cursor cursor = db.rawQuery("Select * from PondSectionDetails where pondSection = ? ", new String[]{pondSection});
        if (cursor.getCount() > 0) {
            long result = db.update("PondSectionDetails", contentValues, "pondSection = ?", new String[]{pondSection});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteSectionDetails(String pondSection) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from PondSectionDetails where pondSection = ? ", new String[]{pondSection});
        if (cursor.getCount() > 0) {
            long result = db.delete("PondSectionDetails", "pondSection = ?", new String[]{pondSection});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getPonSectionDatabyID(String pondSection) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select pondSection,pondSecNum,size,care,fishType,totalFishCapacity  from PondSectionDetails where pondSection= ?", new String[]{pondSection});
        return cursor;
    }
    public Cursor getPonSectionDatabyPond(String pondName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select pondSection,pondSecNum,size,care,fishType,totalFishCapacity  from PondSectionDetails where pondName= ?", new String[]{pondName});
        return cursor;
    }

}
