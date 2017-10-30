package com.example.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inventory.adapter.SectorAdapter;
import com.example.inventory.pojo.Sector;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          Sector
 * @date 30/10/17
 */

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector = (RecyclerView)findViewById(R.id.recyclerSector);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager( new GridLayoutManager(this,2));
        if(savedInstanceState != null){
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        } else {
            sectorAdapter = new SectorAdapter();
        }
        recyclerSector.setAdapter(sectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno los sectores que se han modificado en la vista y no han sido guardados
     * para visualizar el estado correcto onCreate()
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector",sectorAdapter.getSectorsModified());
    }
}
