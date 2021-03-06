package com.example.inventory.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.inventory.data.db.InventoryContract;
import com.example.inventory.data.db.InventoryOpenHelper;
import com.example.inventory.data.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 25/01/18.
 */

public class SectorDaoImpl {

    /**
     * Metodo que devuelve un cursor con todas las dependencias de la base de datos
     * Observable<ArrayList<Sector>>
     * @return
     */
    public ArrayList<Sector> loadAll(){
        ArrayList<Sector> sectors = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.SectorEntry.TABLE_NAME,
                InventoryContract.SectorEntry.ALL_COLUMN,
                null,
                null,
                null,
                null,
                 BaseColumns._ID,
                null);
        sectors.clear();
        if (cursor.moveToFirst()){
            do {
                Sector sector = new Sector(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        true,
                        true);
                sectors.add(sector);
            } while (cursor.moveToNext());
        }
        InventoryOpenHelper.getInstance().closeDateBase();
        // NO SE CIERRA EL CURSOR
        return sectors;
    }

    public boolean exists(Sector sector) {
        return false;
    }

    public long add(Sector sector) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        long id = sqLiteDatabase.insert(InventoryContract.SectorEntry.TABLE_NAME,
                null,CreateContent(sector));
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public int update(Sector sector) {
        Log.e("dao",String.valueOf(sector.getDependencyID()));
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(sector.get_ID())};
        int id = sqLiteDatabase.update(InventoryContract.SectorEntry.TABLE_NAME, CreateContent(sector), where, whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public int delete(Sector sector) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID+"=?";
        String[] whereArgs = new String[] {String.valueOf(sector.get_ID())};
        int id = sqLiteDatabase.delete(InventoryContract.SectorEntry.TABLE_NAME, where, whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public ContentValues CreateContent(Sector sector){
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.SectorEntry.COLUMN_NAME,sector.getName());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME,sector.getSortName());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION,sector.getDescription());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCY,sector.getDependencyID());
        return contentValues;
    }
}
