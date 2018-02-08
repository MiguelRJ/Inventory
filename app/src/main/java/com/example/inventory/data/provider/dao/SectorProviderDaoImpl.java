package com.example.inventory.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.example.inventory.data.base.SectorDao;
import com.example.inventory.data.db.InventoryContract;
import com.example.inventory.data.model.Sector;
import com.example.inventory.data.provider.InventoryProviderContract;
import com.example.inventory.ui.inventory.InventoryApplication;
import java.util.ArrayList;

/**
 * Created by Miguel on 08/02/2018.
 */

public class SectorProviderDaoImpl implements SectorDao {

    @Override
    public ArrayList<Sector> loadAll() {

        ArrayList<Sector> list = new ArrayList<>();

        String[] projections = new String[]{
                InventoryProviderContract.Sector._ID,
                InventoryProviderContract.Sector.NAME,
                InventoryProviderContract.Sector.SHORTNAME,
                InventoryProviderContract.Sector.DESCRIPTION,
                InventoryProviderContract.Sector.DEPENDENCY
        };

        ContentResolver cr = InventoryApplication.getContext().getContentResolver();//todos los content provider estan getionados por esto
        Cursor cursor = cr.query(
                InventoryProviderContract.Sector.CONTENT_URI,
                projections,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                list.add(new Sector(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        true,
                        true
                ));
            }while (cursor.moveToNext());
        }

        return list;
    }

    @Override
    public boolean exists(Sector sector) {
        return false;
    }

    @Override
    public long add(Sector sector) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        Uri uri = cr.insert(
                InventoryProviderContract.Sector.CONTENT_URI,
                CreateContent(sector)
        );
        if (uri==null){
            return -1;
        }
        return Long.parseLong(uri.getLastPathSegment());
    }

    @Override
    public int update(Sector sector) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        String where = InventoryProviderContract.Sector._ID+"=?";
        String[] whereArgs = new String[]{String.valueOf(sector.get_ID())};
        int id = cr.update(
                InventoryProviderContract.Sector.CONTENT_URI,
                CreateContent(sector),
                where,
                whereArgs
        );
        return id;
    }

    @Override
    public int delete(Sector sector) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        int id = cr.delete(
                Uri.parse(InventoryProviderContract.Sector.CONTENT_URI+"/"+String.valueOf(sector.get_ID())),
                null,
                null
        );
        return id;
    }

    @Override
    public ContentValues CreateContent(Sector sector) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.SectorEntry.COLUMN_NAME,sector.getName());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME,sector.getSortName());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION,sector.getDescription());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCY,sector.getDependencyID());
        return contentValues;
    }
}
