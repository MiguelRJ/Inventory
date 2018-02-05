package com.example.inventory.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

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
            sProductInnerProjectionMap.put(_ID,Product.CONTENT_PATH+"."+Product._ID); // Redundante
            sProductInnerProjectionMap.put(NAME, Product.CONTENT_PATH+"."+Product.NAME);
            sProductInnerProjectionMap.put(SERIAL, Product.CONTENT_PATH+"."+Product.SERIAL);
            sProductInnerProjectionMap.put(SELLER, Product.CONTENT_PATH+"."+Product.SELLER);
            sProductInnerProjectionMap.put(MODEL, Product.CONTENT_PATH+"."+Product.MODEL);
            sProductInnerProjectionMap.put(SECTOR_ID,Sector.CONTENT_PATH+"."+Sector._ID);
            sProductInnerProjectionMap.put(SECTOR_NAME,Sector.CONTENT_PATH+"."+Sector.NAME);
            sProductInnerProjectionMap.put(DESCRIPTION, Product.CONTENT_PATH+"."+Product.DESCRIPTION);
            //sProductInnerProjectionMap.put(CATEGORIE_ID,Categorie.CONTENT_PATH+"."+Categorie._ID);
            //sProductInnerProjectionMap.put(CATEGORIE_NAME,Categorie.CONTENT_PATH+"."+Categorie.NAME);
            //sProductInnerProjectionMap.put(TYPE_ID,Type.CONTENT_PATH+"."+Type._ID);
            //sProductInnerProjectionMap.put(TYPE_NAME,Type.CONTENT_PATH+"."+Type.NAME);
            sProductInnerProjectionMap.put(DESCRIPTION, Product.CONTENT_PATH+"."+Product.DESCRIPTION);
            sProductInnerProjectionMap.put(PRICE, Product.CONTENT_PATH+"."+Product.PRICE);
            sProductInnerProjectionMap.put(BUYDATE, Product.CONTENT_PATH+"."+Product.BUYDATE);
            sProductInnerProjectionMap.put(URL, Product.CONTENT_PATH+"."+Product.URL);
            sProductInnerProjectionMap.put(NOTES, Product.CONTENT_PATH+"."+Product.NOTES);

        }
    }

}
