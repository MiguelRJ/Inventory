package com.example.inventory.repository;

import com.example.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by
 * @author Miguel Rodriguez Jimenez
 * @version 1.0.0.0.0.0.0.0
 * @date 26/10/17
 *
 */

public class DependencyRepository {

    /* DECLARACION */
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /* INICIALIZACION */
    /**
     * Inicializar todos los atributos de ambito estatico o de clase
     */
    static{
        dependencyRepository = new DependencyRepository(); // Inicializacion SI o SI garantizado
    }

    /**
     * El metodo debe ser privado para garantizar que solo hay una instancia de Repository
     */
    private DependencyRepository(){
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /* METODOS */
    private void initialize() {
        addDependency(new Dependency(1,"1º Ciclo Formativo Grado Superior", "1CFGS","1CFGS Desarrollo aplicaciones multiplataforma"));
        addDependency(new Dependency(2,"2º Ciclo Formativo Grado Superior", "2CFGS","2CFGS Desarrollo aplicaciones multiplataforma"));
    }

    public DependencyRepository getInstance(){
        if(dependencyRepository==null){ // No se necesita porque ya inicializamos en static{} garantizado
            dependencyRepository = new DependencyRepository();
        }
        return dependencyRepository;
    }

    /**
     * Metodo que aññade una dependencia
     * @param dependency
     */
    public void addDependency(Dependency dependency){
        dependencies.add(dependency);
    }
}
