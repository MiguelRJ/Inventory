package com.example.inventoryFragmentBD.data.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.inventoryFragmentBD.ui.inventory.InventoryApplication;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    private static InventoryOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;

    public InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null, InventoryContract.DATABASE_VERSION);
    }

    public static InventoryOpenHelper getInstance() {
        if (singleton==null) {
            singleton = new InventoryOpenHelper();
        }
        return singleton;
    }

    public void openDateBase(){
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=1");
            }
        }
    }
}
