package com.example.inventoryFragment.data.db.repository;

import android.util.Log;

import com.example.inventoryFragment.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.security.auth.login.LoginException;

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
        initialize();
    }

    /* METODOS */
    private void initialize() {
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
    }

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
    }

    public boolean deleteDependency(Dependency dependency){
        /*for (int i = 0;i<dependencies.size();i++){
            if (dependencies.get(i).get_ID() == id){
                dependencies.remove(i);
                return true;
            }
        }*/
        return false;
    }

    /**
     * Metodo que devuelve las dependencias
     *
     * @return
     */
    public ArrayList<Dependency> getDependencies() {
        /**
         * El array list se ordena segun el criterio/s del metodo compareTo de la interfaz Comparable
         */
        Collections.sort(dependencies); // ordena el arraylist
        return dependencies; // devolverlo ya ordenado
    }

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
}
