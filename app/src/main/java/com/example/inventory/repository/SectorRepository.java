package com.example.inventory.repository;

import com.example.inventory.pojo.Sector;
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
        initialize();
    }

    /* METODOS */
    private void initialize() {
        addSector(new Sector(1, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addSector(new Sector(2, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
    }

    public static SectorRepository getInstance() {
        /* No se necesita porque ya inicializamos en static{} garantizado
        if(sectorRepository==null){ sectorRepository = new SectorRepository(); }*/
        return sectorRepository;
    }

    /**
     * Metodo que añade un sector
     *
     * @param sector
     */
    public void addSector(Sector sector) {
        sectors.add(sector);
    }

    /**
     * Metodo que devuelve los sectores
     *
     * @return
     */
    public ArrayList<Sector> getSectors() {
        return sectors;
    }
}
