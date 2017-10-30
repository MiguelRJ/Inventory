package com.example.inventory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.pojo.Sector;
import com.example.inventory.repository.SectorRepository;

import java.util.ArrayList;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          Sector
 * @date 30/10/17
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {

    private ArrayList<Sector> sectors;

    public SectorAdapter(){
        sectors = SectorRepository.getInstance().getSectors();
    }

    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1.
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2.
        View view = inflater.inflate(R.layout.item_sector,null);

        // 3.
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }

    @Override
    public void onBindViewHolder(SectorViewHolder sectorViewHolder, int position) {
        sectorViewHolder.swEnabled.setChecked(sectors.get(position).isEnabled());
        sectorViewHolder.txvNameSector.setText(sectors.get(position).getName());
        if(sectors.get(position).isSectorDefault()){
            sectorViewHolder.txvSectorDefault.setText(R.string.txvSectorDefault);
        }
    }

    /**
     * Se crearan tantos elemetnos SectorViewHolder como elementos haya en el ArrayList definido dentro de la clase
     * @return el numero de elementos que tiene el array
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }

    public static class SectorViewHolder extends RecyclerView.ViewHolder{
        private Switch swEnabled;
        private TextView txvNameSector;
        private TextView txvSectorDefault;

        public SectorViewHolder(View view) {
            super(view);
            swEnabled = view.findViewById(R.id.swEnabled);
            txvNameSector = view.findViewById(R.id.txvNameSector);
            txvSectorDefault = view.findViewById(R.id.txvSectorDefault);
        }
    }
}


