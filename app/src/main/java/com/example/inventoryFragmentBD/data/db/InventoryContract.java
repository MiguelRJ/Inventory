package com.example.inventoryFragmentBD.data.db;

import android.provider.BaseColumns;

import com.example.inventoryFragmentBD.data.db.model.Product;
import com.example.inventoryFragmentBD.data.db.model.Type;

import java.util.HashMap;

/**
 * Created by usuario on 19/01/18.
 *
 * DATABASE_VERSION=1;
 *      dependency
 * DATABASE_VERSION=2;
 *      sector
 * DATABASE_VERSION=3;
 *      sector foreign key
 * DATABASE_VERSION=4;
 *      sector foreign key references dependency (_id)
 * DATABASE_VERSION=5,6,7;
 *      SQLiteException: no such column: dependency
 *      ERROR el insert de los datos predefinidos estaba incorrecto entonces no creaba la tabla con el foreign key
 * DATABASE_VERSION=8,9,10;
 *      Creadas tablas type categorie y product
 * DATABASE_VERSION=11,12;
 *      No puedo acceder a la base de datos desde adb shell en clase
 */

public final class InventoryContract {

    // la clase no se puede instanciar
    private InventoryContract(){

    }

    public static final int DATABASE_VERSION=12;
    public static final String DATABASE_NAME="Inventory.db";

    // Por cada tabla se crea una clase que implementa la interfaz BaseColumns
    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMN = new String[] {
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        /**
         * CREATE
         */
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL )",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME
        );

        /**
         * DELETE
         */
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        /**
         * INSERT
         */
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                "Aula de 2CFGS",
                "2CFGS",
                "Aula de los resopladores de 2CFGS",
                "No tengo imagen"
        )+String.format(" ('%s','%s','%s','%s')",
                "Aula de 1CFGS",
                "1CFGS",
                "Aula de los resopladores de 1CFGS",
                "No tengo imagen"
        );

    }

    public static class SectorEntry implements BaseColumns {
        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DEPENDENCY = "dependency";
        public static final String[] ALL_COLUMN = new String[] {
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCY
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        /**
         * CREATE
         */
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "FOREIGN KEY (%s) REFERENCES %s (%s) on update cascade on delete restrict )",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCY,
                COLUMN_DEPENDENCY,
                DependencyEntry.TABLE_NAME.toString(),
                BaseColumns._ID
        );

        /**
         * DELETE
         */
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        /**
         * INSERT
         */
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCY,
                "Armario A",
                "ArmA",
                "Armario puerta madera",
                "1"
        )+String.format(" ('%s','%s','%s','%s')",
                "Armario B",
                "ArmB",
                "Armario puerta cristal",
                "2"
        );

    }

    public static class TypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "type";
        public static final String COLUMN_NAME = "name";
        public static final String[] ALL_COLUMN = new String[]{
                BaseColumns._ID,
                COLUMN_NAME
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL )",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s) VALUES ('%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                "type 1"
        )+String.format(" ('%s')",
                "type 2"
        );
    }

    public static class CategorieEntry implements BaseColumns {
        public static final String TABLE_NAME = "categorie";
        public static final String COLUMN_NAME = "name";
        public static final String[] ALL_COLUMN = new String[]{
                BaseColumns._ID,
                COLUMN_NAME
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL )",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME
        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s) VALUES ('%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                "categorie 1"
        )+String.format(" ('%s')",
                "categorie 2"
        );
    }

    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_SELLER = "seller";
        public static final String COLUMN_MODEL = "model";
        public static final String COLUMN_SECTOR = "sector";
        public static final String COLUMN_CATEGORIE = "categorie";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_BUYDATE = "buydate";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_NOTES = "notes";
        public static final String[] ALL_COLUMN = new String[]{
                BaseColumns._ID,
                COLUMN_NAME,COLUMN_SERIAL,COLUMN_SELLER,COLUMN_MODEL,COLUMN_SECTOR,
                COLUMN_CATEGORIE,COLUMN_TYPE,COLUMN_DESCRIPTION,
                COLUMN_PRICE,COLUMN_BUYDATE,COLUMN_URL,COLUMN_NOTES
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "FOREIGN KEY (%s) REFERENCES %s (%s) on update cascade on delete restrict, "+
                        "FOREIGN KEY (%s) REFERENCES %s (%s) on update cascade on delete restrict, "+
                        "FOREIGN KEY (%s) REFERENCES %s (%s) on update cascade on delete restrict )",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SERIAL,
                COLUMN_SELLER,
                COLUMN_MODEL,
                COLUMN_SECTOR,
                COLUMN_CATEGORIE,
                COLUMN_TYPE,
                COLUMN_DESCRIPTION,
                COLUMN_PRICE,
                COLUMN_BUYDATE,
                COLUMN_URL,
                COLUMN_NOTES,
                COLUMN_SECTOR, SectorEntry.TABLE_NAME, BaseColumns._ID,
                COLUMN_CATEGORIE, CategorieEntry.TABLE_NAME, BaseColumns._ID,
                COLUMN_TYPE, TypeEntry.TABLE_NAME, BaseColumns._ID

        );

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SERIAL,
                COLUMN_SELLER,
                COLUMN_MODEL,
                COLUMN_SECTOR,
                COLUMN_CATEGORIE,
                COLUMN_TYPE,
                COLUMN_DESCRIPTION,
                COLUMN_PRICE,
                COLUMN_BUYDATE,
                COLUMN_URL,
                COLUMN_NOTES,
                "p 1",
                "serial 1",
                "seller 1",
                "model 1",
                "1",
                "1",
                "1",
                "desc 1",
                "price 1",
                "date 1",
                "url 1",
                "note 1"
        )+String.format(" ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                "p 2",
                "serial 2",
                "seller 2",
                "model 2",
                "2",
                "2",
                "2",
                "desc 2",
                "price 2",
                "date 2",
                "url 2",
                "note 2"
        );
    }

    public static class ProductInnerEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_SELLER = "seller";
        public static final String COLUMN_MODEL = "model";
        public static final String COLUMN_SECTOR_ID = "sectorId";
        public static final String COLUMN_SECTOR_NAME = "sectorName";
        public static final String COLUMN_CATEGORIE_ID = "categorieId";
        public static final String COLUMN_CATEGORIE_NAME = "categorieName";
        public static final String COLUMN_TYPE_ID = "typeId";
        public static final String COLUMN_TYPE_NAME = "typeName";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_BUYDATE = "buydate";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_NOTES = "notes";
        public static final String[] ALL_COLUMN = new String[]{
                BaseColumns._ID,
                COLUMN_NAME,COLUMN_SERIAL,COLUMN_SELLER,COLUMN_MODEL,
                COLUMN_SECTOR_ID,COLUMN_SECTOR_NAME,
                COLUMN_CATEGORIE_ID,COLUMN_CATEGORIE_NAME,
                COLUMN_TYPE_ID,COLUMN_TYPE_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_PRICE,COLUMN_BUYDATE,COLUMN_URL,COLUMN_NOTES
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        /**
         *
         * select * from (
         *      select * from (
         *          select * from product INNER JOIN categorie on categorie=categorie._id
         *      ) INNER JOIN type on type=type._id
         * ) INNER JOIN sector on sector=sector._id;
         *
         */
        public static final String PRODUCT_INNER = String.format("%s INNER JOIN %s ON %s=%s.%s",
                ProductInnerEntry.TABLE_NAME,
                CategorieEntry.TABLE_NAME,
                ProductInnerEntry.COLUMN_CATEGORIE_ID,
                CategorieEntry.TABLE_NAME,
                CategorieEntry._ID);

        public static HashMap<String,String> sProductInnerProjectionMap;
        static {

            sProductInnerProjectionMap = new HashMap<>();
            sProductInnerProjectionMap.put(_ID,ProductInnerEntry.TABLE_NAME+"."+ProductInnerEntry._ID); // Redundante
            sProductInnerProjectionMap.put(COLUMN_NAME, ProductInnerEntry.TABLE_NAME+"."+ProductInnerEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(COLUMN_DESCRIPTION, ProductInnerEntry.TABLE_NAME+"."+ProductInnerEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(COLUMN_CATEGORIE_ID,CategorieEntry.TABLE_NAME+"."+CategorieEntry._ID);
            sProductInnerProjectionMap.put(COLUMN_CATEGORIE_NAME,CategorieEntry.TABLE_NAME+"."+CategorieEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(COLUMN_TYPE_ID,TypeEntry.TABLE_NAME+"."+TypeEntry._ID);
            sProductInnerProjectionMap.put(COLUMN_TYPE_NAME,TypeEntry.TABLE_NAME+"."+TypeEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(COLUMN_SECTOR_ID,SectorEntry.TABLE_NAME+"."+SectorEntry._ID);
            sProductInnerProjectionMap.put(COLUMN_SECTOR_NAME,SectorEntry.TABLE_NAME+"."+SectorEntry.COLUMN_NAME);

        }
    }

}
