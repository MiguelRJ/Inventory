package com.example.inventoryFragmentBD.data.db.repository;

import com.example.inventoryFragmentBD.data.db.dao.SectorDao;
import com.example.inventoryFragmentBD.data.db.model.Sector;
import java.util.ArrayList;

/**
 * Created by
 * @author Miguel Rodriguez Jimenez
 * @version 1.0.0.0.0.0.0.0
 * @date 26/10/17
 */

public class SectorRepository {
    /* DECLARACION */
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;
    private SectorDao dao;

    /* INICIALIZACION */

    /**
     * Inicializar todos los atributos de ambito estatico o de clase
     */
    static {// Inicializacion SI o SI garantizado
        sectorRepository = new SectorRepository();
    }

    /**
     * El metodo debe ser privado para garantizar que solo hay una instancia de Repository
     */
    private SectorRepository() {
        this.sectors = new ArrayList<>();
        dao = new SectorDao();
        //initialize();
    }

    /* METODOS */
    /*private void initialize() {
        addSector(new Sector( 1,"Armario A","ArmA","Armario puerta madera",1,true,true));
        addSector(new Sector( 2,"Armario B","ArmB","Armario puerta cristal",2,false,true));
        addSector(new Sector( 3,"Mesa A","MesA","Mesa madera",1,true,true));
        addSector(new Sector( 4,"Mesa B","MesB","Mesa cristal",2,false,true));
        addSector(new Sector( 5,"Silla A","SilA","Silla madera",1,true,true));
        addSector(new Sector( 6,"Silla B","SilB","Silla cristal",2,false,true));
        addSector(new Sector( 7,"Pizarra A","PizA","Pizarra tiza",1,true,true));
        addSector(new Sector( 8,"Pizarra B","PizB","Pizarra rotulador",2,false,true));
        addSector(new Sector( 9,"Ordenador A","OrdA","Ordendaor madera",1,true,true));
        addSector(new Sector( 10,"Ordenador B","OrdB","Ordenador cristal",2,false,true));
    }*/

    public static SectorRepository getInstance() {
        /* No se necesita porque ya inicializamos en static{} garantizado
        if(sectorRepository==null){ sectorRepository = new SectorRepository(); }*/
        return sectorRepository;
    }

    public int getSectorBy(String name, String shortname){
        for (int i = 0;i<sectors.size();i++){
            //Log.e(String.valueOf(dependencies.get(i).get_ID()),String.valueOf(name+"--"+shortname));
            if (sectors.get(i).getName().equals(name) && sectors.get(i).getSortName().equals(shortname)){
                return sectors.get(i).get_ID();
            }
        }
        return -1;
    }

    public void editDependencyById(int id,String name, String shortname, String description){
        for (int i = 0; i < sectors.size();i++){
            if (sectors.get(i).get_ID() == id){
                sectors.get(i).setName(name);
                sectors.get(i).setSortName(shortname);
                sectors.get(i).setDescription(description);
            }
        }
    }

    /**
     * Metodo que añade un sector
     *
     * @param sector
     */
    public void addSector(Sector sector) {
        //sectors.add(sector);
        dao.add(sector);
    }

    /**
     * Metodo que devuelve los sectores
     *
     * @return
     */
    public ArrayList<Sector> getSectors() {
        sectors = dao.loadAll();
        return sectors;
    }
}
