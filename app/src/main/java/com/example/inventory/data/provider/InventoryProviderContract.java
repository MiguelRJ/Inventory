package com.example.inventory.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.inventory.data.db.InventoryContract;

import java.net.URI;
import java.util.HashMap;

/**
 * Created by usuario on 5/02/18.
 */

public final class InventoryProviderContract {

    public static final String AUTHORITY = "com.example.inventory";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    private InventoryProviderContract() {

    }

    public static class Dependency implements BaseColumns {
        public static final String CONTENT_PATH = "dependency";
        public static final Uri CONTENT_URI= Uri.withAppendedPath(InventoryProviderContract.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGENAME = "imageName";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME,
                SHORTNAME,
                DESCRIPTION,
                IMAGENAME
        };
    }

    public static class Sector implements BaseColumns {
        public static final String CONTENT_PATH = "sector";
        public static final Uri CONTENT_URI= Uri.withAppendedPath(InventoryProviderContract.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String DEPENDENCY = "dependency";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME,
                SHORTNAME,
                DESCRIPTION,
                DEPENDENCY
        };
    }

    public static class Categorie implements BaseColumns {
        public static final String CONTENT_PATH = "categorie";
        public static final String NAME = "name";
        public static final String[] PROJECTION = new String[]{
                BaseColumns._ID,
                NAME
        };
    }

    public static class Type implements BaseColumns {
        public static final String CONTENT_PATH = "type";
        public static final String NAME = "name";
        public static final String[] PROJECTION = new String[]{
                BaseColumns._ID,
                NAME
        };
    }
    
    public static class Product implements BaseColumns {
        public static final String CONTENT_PATH = "product";
        public static final Uri CONTENT_URI= Uri.withAppendedPath(InventoryProviderContract.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SERIAL = "serial";
        public static final String SELLER = "seller";
        public static final String MODEL = "model";
        public static final String SECTOR_ID = "sector";
        public static final String SECTOR_NAME = "sectorName";
        public static final String CATEGORIE_ID = "categorie";
        public static final String CATEGORIE_NAME = "categorieName";
        public static final String TYPE_ID = "type";
        public static final String TYPE_NAME = "typeName";
        public static final String DESCRIPTION = "description";
        public static final String PRICE = "price";
        public static final String BUYDATE = "buydate";
        public static final String URL = "url";
        public static final String NOTES = "notes";
        public static final String[] PROJECTION = new String[]{
                BaseColumns._ID,
                NAME, SERIAL, SELLER, MODEL,
                SECTOR_ID, SECTOR_NAME,
                CATEGORIE_ID, CATEGORIE_NAME,
                TYPE_ID, TYPE_NAME,
                DESCRIPTION, PRICE, BUYDATE, URL, NOTES
        };

        public static HashMap<String,String> sProductInnerProjectionMap;
        
        static {
            sProductInnerProjectionMap = new HashMap<>();
            sProductInnerProjectionMap.put(_ID, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+ InventoryContract.ProductInnerEntry._ID); // Redundante
            sProductInnerProjectionMap.put(NAME, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(SERIAL, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_SERIAL);
            sProductInnerProjectionMap.put(SELLER, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_SELLER);
            sProductInnerProjectionMap.put(MODEL, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_MODEL);
            sProductInnerProjectionMap.put(SECTOR_ID,InventoryContract.SectorEntry.TABLE_NAME+"."+Sector._ID);
            sProductInnerProjectionMap.put(SECTOR_NAME,InventoryContract.SectorEntry.TABLE_NAME+"."+Sector.NAME);
            sProductInnerProjectionMap.put(DESCRIPTION, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(CATEGORIE_ID,Categorie.CONTENT_PATH+"."+Categorie._ID);
            sProductInnerProjectionMap.put(CATEGORIE_NAME,Categorie.CONTENT_PATH+"."+Categorie.NAME);
            sProductInnerProjectionMap.put(TYPE_ID,Type.CONTENT_PATH+"."+Type._ID);
            sProductInnerProjectionMap.put(TYPE_NAME,Type.CONTENT_PATH+"."+Type.NAME);
            sProductInnerProjectionMap.put(DESCRIPTION, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(PRICE, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_PRICE);
            sProductInnerProjectionMap.put(BUYDATE, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_BUYDATE);
            sProductInnerProjectionMap.put(URL, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_URL);
            sProductInnerProjectionMap.put(NOTES, InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_NOTES);
        }
        
    }

}
