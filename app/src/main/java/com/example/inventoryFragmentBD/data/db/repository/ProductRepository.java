package com.example.inventoryFragmentBD.data.db.repository;

import com.example.inventoryFragmentBD.data.db.dao.ProductDao;
import com.example.inventoryFragmentBD.data.db.model.Product;
import com.example.inventoryFragmentBD.data.db.model.ProductInner;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductRepository {

    /* DECLARACION */
    private ArrayList<Product> products;
    private ProductDao dao;
    private static ProductRepository productRepository;

    /* INICIALIZACION */

    /**
     * Inicializar todos los atributos de ambito estatico o de clase
     */
    static {// Inicializacion SI o SI garantizado
        productRepository = new ProductRepository();
    }

    /**
     * El metodo debe ser privado para garantizar que solo hay una instancia de Repository
     */
    private ProductRepository() {
        this.products = new ArrayList<>();
        this.dao = new ProductDao();
        //initialize();
    }

    public static ProductRepository getInstance(){
        return productRepository;
    }

    public ArrayList<Product> getProducts(){
        return dao.loadAll();
    }

    public ProductInner getProductByInt(int id) {
        return dao.search(id);
    }
}
