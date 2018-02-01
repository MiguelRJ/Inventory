package com.example.inventoryFragmentBD.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.inventoryFragmentBD.data.db.InventoryContract;
import com.example.inventoryFragmentBD.data.db.InventoryOpenHelper;
import com.example.inventoryFragmentBD.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {

    public ArrayList<Product> loadAll() {

        final ArrayList<Product> products = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProducteEntry.TABLE_NAME,
                InventoryContract.ProducteEntry.ALL_COLUMN,
                null,
                null,
                null,
                null,
                BaseColumns._ID,
                null);
        products.clear();
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getString(8),
                        cursor.getFloat(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12)
                );
                products.add(product);
            } while (cursor.moveToNext());
        }
        InventoryOpenHelper.getInstance().closeDateBase();

        // NO SE CIERRA EL CURSOR

        return products;
    }


    public long add(Product product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME,
                null, CreateContent(product));
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public int update(Product product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(product.get_id())};
        int id = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, CreateContent(product), where, whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return 0;
    }

    public int delete(Product product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(product.get_id())};
        int id = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME,where,whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    public ContentValues CreateContent(Product product) {
        ContentValues contentValues = new ContentValues();
        return contentValues;
    }
}
