package com.example.inventory.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.inventory.data.db.InventoryContract;
import com.example.inventory.data.db.InventoryOpenHelper;
import com.example.inventory.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {

    /**
     * Metodo que devuelve un cursor con todas las dependencias de la base de datos
     * Observable<ArrayList<Dependency>>
     *
     * @return
     */
    public ArrayList<Dependency> loadAll() {

        final ArrayList<Dependency> dependencies = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMN,
                null,
                null,
                null,
                null,
                BaseColumns._ID,
                null);
        dependencies.clear();
        if (cursor.moveToFirst()) {
            do {
                Dependency dependency = new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                dependencies.add(dependency);
            } while (cursor.moveToNext());
        }
        InventoryOpenHelper.getInstance().closeDateBase();

        // NO SE CIERRA EL CURSOR

        return dependencies;
    }

    public boolean exists(Dependency dependency) {
        return false;
    }

    public long add(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME,
                null, CreateContent(dependency));
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public int update(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(dependency.get_ID())};
        int id = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, CreateContent(dependency), where, whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public int delete(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(dependency.get_ID())};
        int id = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME,where,whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public ContentValues CreateContent(Dependency dependency) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getSortName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());
        return contentValues;
    }
}
