package com.example.inventory.data.base;

import android.content.ContentValues;
import com.example.inventory.data.model.Sector;
import java.util.ArrayList;

/**
 * Created by Miguel on 08/02/2018.
 */

public interface SectorDao {
    ArrayList<Sector> loadAll();
    boolean exists(Sector sector);
    long add(Sector sector);
    int update(Sector sector);
    int delete(Sector sector);
    ContentValues CreateContent(Sector sector);
}
