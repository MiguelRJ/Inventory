package com.example.inventory.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.inventory.data.base.ProductDao;
import com.example.inventory.data.db.InventoryContract;
import com.example.inventory.data.db.InventoryOpenHelper;
import com.example.inventory.data.model.Product;
import com.example.inventory.data.model.ProductInner;
import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDaoImpl implements ProductDao {

    @Override
    public ArrayList<Product> loadAll() {

        final ArrayList<Product> products = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME,
                InventoryContract.ProductEntry.ALL_COLUMN,
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

    @Override
    public boolean exists(Product product) {
        return false;
    }

    @Override
    public long add(Product product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME,
                null, CreateContent(product));
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    @Override
    public int update(Product product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(product.get_id())};
        int id = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, CreateContent(product), where, whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return 0;
    }

    @Override
    public int delete(Product product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        String where = BaseColumns._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(product.get_id())};
        int id = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME,where,whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return id;
    }

    @Override
    public ProductInner search(int id){
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        ProductInner productInner = null;
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(InventoryContract.ProductInnerEntry.PRODUCT_INNER);
        sqLiteQueryBuilder.setProjectionMap(InventoryContract.ProductInnerEntry.sProductInnerProjectionMap);

        String selection = InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry._ID+"=?";
        String[] selectionArgs = {id+""};
        // 1. Vamos a mostrar si la consulta es correcta
        String sql = sqLiteQueryBuilder.buildQuery(
                InventoryContract.ProductInnerEntry.ALL_COLUMN,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null
        );
        Log.i("sql inner",sql);
        Cursor cursor = sqLiteQueryBuilder.query(
                sqLiteDatabase,
                InventoryContract.ProductInnerEntry.ALL_COLUMN,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            int i = 0;
            productInner = new ProductInner(
                    cursor.getInt(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getInt(i++),
                    cursor.getInt(i++),
                    cursor.getInt(i++),
                    cursor.getString(i++),
                    cursor.getFloat(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getString(i++),
                    cursor.getString(i++)
            );
        }

        return productInner;
    }

    @Override
    public ContentValues CreateContent(Product product) {
        ContentValues contentValues = new ContentValues();
        return contentValues;
    }
}
