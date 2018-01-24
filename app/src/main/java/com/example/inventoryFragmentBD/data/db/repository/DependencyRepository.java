package com.example.inventoryFragmentBD.data.db.repository;

import android.database.Cursor;

import com.example.inventoryFragmentBD.data.db.dao.DependencyDao;
import com.example.inventoryFragmentBD.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          DependencyRepository
 *          Clase principal para gestionar un ArrayList de Dependency
 *          Declarar campos
 *          Inicializar statics
 *          Constructor
 *          Anadir dependencias desde codigo
 *          Obtener la instancia del dependencyRepository
 *          Anadir dependencias metodo add
 *          Obtener la el ArrayList de Dependency
 * @date 26/10/17
 */

public class DependencyRepository {

    /* DECLARACION */
    private ArrayList<Dependency> dependencies;
    private DependencyDao dao;
    private static DependencyRepository dependencyRepository;

    /* INICIALIZACION */

    /**
     * Inicializar todos los atributos de ambito estatico o de clase
     */
    static {// Inicializacion SI o SI garantizado
        dependencyRepository = new DependencyRepository();
    }

    /**
     * El metodo debe ser privado para garantizar que solo hay una instancia de Repository
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        this.dao = new DependencyDao();
        //initialize();
    }

    /* METODOS */
    /*private void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "aaa", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "bbb", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(3, "3º Ciclo Formativo Grado Superior", "DDD", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(4, "4º Ciclo Formativo Grado Superior", "AAA", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(5, "5º Ciclo Formativo Grado Superior", "5CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(6, "6º Ciclo Formativo Grado Superior", "6CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(7, "7º Ciclo Formativo Grado Superior", "7CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(8, "8º Ciclo Formativo Grado Superior", "8CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(9, "9º Ciclo Formativo Grado Superior", "9CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(10, "10º Ciclo Formativo Grado Superior", "10CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
    }*/

    public static DependencyRepository getInstance() {
        /* No se necesita porque ya inicializamos en static{} garantizado
        if(dependencyRepository==null){ dependencyRepository = new DependencyRepository(); }*/
        return dependencyRepository;
    }

    public void editDependencyById(int id,String name, String shortname, String description){
        for (int i = 0; i < dependencies.size();i++){
            if (dependencies.get(i).get_ID() == id){
                dependencies.get(i).setName(name);
                dependencies.get(i).setSortName(shortname);
                dependencies.get(i).setDescription(description);
            }
        }
    }

    public int getDependencyBy(String name, String shortname){
        for (int i = 0;i<dependencies.size();i++){
            //Log.e(String.valueOf(dependencies.get(i).get_ID()),String.valueOf(name+"--"+shortname));
            if (dependencies.get(i).getName().equals(name) && dependencies.get(i).getSortName().equals(shortname)){
                return dependencies.get(i).get_ID();
            }
        }
        return -1;
    }

    /**
     * Metodo que añade una dependencia
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
        dao.save(dependency);
        //dao.addDependency(dependency);
    }

    /*public boolean deleteDependency(Dependency dependency){
        /*for (int i = 0;i<dependencies.size();i++){
            if (dependencies.get(i).get_ID() == id){
                dependencies.remove(i);
                return true;
            }
        }
        return false;
    }*/

    /**
     * Metodo que devuelve las dependencias
     *
     * @return
     */
    public ArrayList<Dependency> getDependencies() {
        //El array list se ordena segun el criterio/s del metodo compareTo de la interfaz Comparable
        //Collections.sort(dependencies); // ordena el arraylist
        //return dependencies; // devolverlo ya ordenado

        return dao.loadAll();

        /*dependencies.clear();
        Cursor cursor = getDependenciesCursor();
        if (cursor.moveToFirst()){
            do {
                Dependency dependency = new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                dependencies.add(dependency);
            } while (cursor.moveToNext());
        }
        return dependencies;*/
    }

    /*public Cursor getDependenciesCursor(){
        return dao.loadAll();
    }*/

    public ArrayList<Dependency> getDependenciesByShortName(){
        Collections.sort(dependencies, new Dependency.DependencyOrderByShortName());
        return dependencies;
    }

    /**
     * elimina con iterator no hacer con for!
     * @param d
     */
    public void deleteDependencyIterator(Dependency d){
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependency;
        while (iterator.hasNext()){
            dependency = iterator.next();
            if (dependency.getName().equals(d.getName())){
                iterator.remove();
                break;
            }
        }
    }

    public boolean exists(Dependency dependency){
        return dao.exists(dependency);
    }

    public long saveDependency(Dependency dependency){
        return dao.save(dependency);
    }

    public void deleteDependency(Dependency dependency){
        return;
    }
}
