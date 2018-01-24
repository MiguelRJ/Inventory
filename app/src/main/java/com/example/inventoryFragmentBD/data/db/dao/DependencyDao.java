package com.example.inventoryFragmentBD.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventoryFragmentBD.data.db.InventoryContract;
import com.example.inventoryFragmentBD.data.db.InventoryOpenHelper;
import com.example.inventoryFragmentBD.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {




    /**
     * Metodo que devuelve un cursor con todas las dependencias de la base de datos
     * Observable<ArrayList<Dependency>>
     * @return
     */
    public ArrayList<Dependency> loadAll(){
        ArrayList<Dependency> dependencies = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMN,
                null,
                null,
                null,
                null,
                InventoryContract.DependencyEntry.DEFAULT_SORT,
                null);
        dependencies.clear();
        if (cursor.moveToFirst()){
            do {
                Dependency dependency = new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
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

    public long save(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME,dependency.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME,dependency.getSortName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION,dependency.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME,dependency.getImageName());
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME,
                null,contentValues);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }
}
