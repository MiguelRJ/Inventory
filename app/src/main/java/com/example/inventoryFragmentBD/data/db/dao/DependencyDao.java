package com.example.inventoryFragmentBD.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventoryFragmentBD.data.db.InventoryContract;
import com.example.inventoryFragmentBD.data.db.InventoryOpenHelper;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {


    /**
     * Metodo que devuelve un cursor con todas las dependencias de la base de datos
     * @return
     */
    public Cursor loadAll(){

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMN,
                null,
                null,
                null,
                null,
                InventoryContract.DependencyEntry.DEFAULT_SORT,
                null);
        InventoryOpenHelper.getInstance().closeDateBase();
        // NO SE CIERRA EL CURSOR
        return cursor;
    }
}
