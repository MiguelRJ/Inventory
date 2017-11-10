package com.example.inventoryMaterial.data.db.repository;

import com.example.inventoryMaterial.data.db.model.Dependency;

import java.util.ArrayList;

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
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(3, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(4, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(5, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(6, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(7, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(8, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(9, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(10, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones multiplataforma"));

    }

    public static DependencyRepository getInstance() {
        /* No se necesita porque ya inicializamos en static{} garantizado
        if(dependencyRepository==null){ dependencyRepository = new DependencyRepository(); }*/
        return dependencyRepository;
    }

    /**
     * Metodo que añade una dependencia
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }

    /**
     * Metodo que devuelve las dependencias
     *
     * @return
     */
    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
