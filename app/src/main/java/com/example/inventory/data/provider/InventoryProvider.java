package com.example.inventory.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.inventory.data.db.InventoryContract;
import com.example.inventory.data.db.InventoryOpenHelper;

/**
 * Created by usuario on 5/02/18.
 */

public class InventoryProvider extends ContentProvider {

    // Se debe crear una scontante por cada peticion/uri que pueda recpger el content provider
    private static final int PRODUCT=1;
    private static final int PRODUCT_ID=2;
    private static final int DEPENDENCY=3;
    private static final int DEPENDENCY_ID=4;
    private static final int SECTOR=5;
    private static final int SECTOR_ID=6;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private SQLiteDatabase sqLiteDatabase;

    static { // Dada ua Uri ya sabemos que hacer con estos match
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,
                InventoryProviderContract.Product.CONTENT_PATH, PRODUCT);

        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,
                InventoryProviderContract.Product.CONTENT_PATH+"/#", PRODUCT_ID);

        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,
                InventoryProviderContract.Dependency.CONTENT_PATH, DEPENDENCY);

        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,
                InventoryProviderContract.Dependency.CONTENT_PATH+"/#", DEPENDENCY_ID);

        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,
                InventoryProviderContract.Sector.CONTENT_PATH, SECTOR);

        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,
                InventoryProviderContract.Sector.CONTENT_PATH+"/#", SECTOR_ID);
    }

    @Override
    public boolean onCreate() {
        sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor cursor = null;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                break;

            case PRODUCT_ID:
                break;

            case DEPENDENCY:
                cursor = sqLiteDatabase.query(
                        InventoryContract.DependencyEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case DEPENDENCY_ID:
                break;

            case SECTOR:
                cursor = sqLiteDatabase.query(
                        InventoryContract.SectorEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case SECTOR_ID:
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: "+ uri);

        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        /* sto sirve para los intent par trabajar con tipos de datos,
         * intent siempre ha sido de una activity a otra, (.class)
         * intent explicito quiero algo, si quiero una foto, dame algo o haz una foto
         * dame un tipo de dato de imagen MIME TYPE (image/png, image/jpe, imgae/gif)
         * tenemos que establecer que tipo de datos son los que devolvemos
         * vnd.android.cursor.dir - vas a devolver un conjunto de elementos
         * vnd.anroid.cursor.item - vas a devolver un elemento
         *
         * Ejemplo para dir (cuando se obtienen muchas dependency)
         *      vnd.android.cursor.dir/vnd.com.example.inventory/dependency
         *
         * Ejemplo para item (cuando se obtiene una dependency)
         *      vnd.android.cursor.item/vnd.com.example.inventory/dependency
         * */

        String DIR = "vnd.android.cursor.dir/vnd.";
        String ITEM = "vnd.android.cursor.item/vnd.";

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                return (DIR+
                        InventoryProviderContract.AUTHORITY+"/"+
                        InventoryProviderContract.Product.CONTENT_PATH);
            case PRODUCT_ID:
                return (ITEM+
                        InventoryProviderContract.AUTHORITY+"/"+
                        InventoryProviderContract.Product.CONTENT_PATH);

            case DEPENDENCY:
                return (DIR+
                        InventoryProviderContract.AUTHORITY+"/"+
                        InventoryProviderContract.Dependency.CONTENT_PATH);
            case DEPENDENCY_ID:
                return (ITEM+
                        InventoryProviderContract.AUTHORITY+"/"+
                        InventoryProviderContract.Dependency.CONTENT_PATH);

            case SECTOR:
                return (DIR+
                        InventoryProviderContract.AUTHORITY+"/"+
                        InventoryProviderContract.Sector.CONTENT_PATH);
            case SECTOR_ID:
                return (ITEM+
                        InventoryProviderContract.AUTHORITY+"/"+
                        InventoryProviderContract.Sector.CONTENT_PATH);

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: "+ uri);

        }

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        Long result = null;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                break;

            case DEPENDENCY:
                result = sqLiteDatabase.insert(
                        InventoryContract.DependencyEntry.TABLE_NAME,
                        null,
                        contentValues
                );
                break;

            case SECTOR:
                result = sqLiteDatabase.insert(
                        InventoryContract.SectorEntry.TABLE_NAME,
                        null,
                        contentValues
                );
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: "+ uri);

        }

        if (result==-1){
            return null;
        }
        return Uri.parse(uri+"/"+result);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String where, @Nullable String[] whereArgs) {
        long result = 0;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                break;

            case DEPENDENCY:
                result = sqLiteDatabase.delete(
                        InventoryContract.DependencyEntry.TABLE_NAME,
                        where,
                        whereArgs
                );
                break;

            case DEPENDENCY_ID:
                result = sqLiteDatabase.delete(
                        InventoryContract.DependencyEntry.TABLE_NAME,
                        InventoryProviderContract.Dependency._ID+"=?",
                        new String[]{uri.getLastPathSegment()}
                );
                break;

            case SECTOR:
                result = sqLiteDatabase.delete(
                        InventoryContract.SectorEntry.TABLE_NAME,
                        where,
                        whereArgs
                );
                break;

            case SECTOR_ID:
                result = sqLiteDatabase.delete(
                        InventoryContract.SectorEntry.TABLE_NAME,
                        InventoryProviderContract.Sector._ID+"=?",
                        new String[]{uri.getLastPathSegment()}
                );
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: "+ uri);

        }

        if (result==-1){
            return -1;
        }
        return Integer.parseInt(String.valueOf(result));
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String where, @Nullable String[] whereArgs) {
        long result = 0;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                break;

            case DEPENDENCY:
                result = sqLiteDatabase.update(
                        InventoryContract.DependencyEntry.TABLE_NAME,
                        contentValues,
                        where,
                        whereArgs
                );
                break;

            case SECTOR:
                result = sqLiteDatabase.update(
                        InventoryContract.SectorEntry.TABLE_NAME,
                        contentValues,
                        where,
                        whereArgs
                );
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: "+ uri);

        }

        if (result==-1){
            return -1;
        }
        return Integer.parseInt(String.valueOf(result));
    }

}
