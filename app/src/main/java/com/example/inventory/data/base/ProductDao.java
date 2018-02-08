package com.example.inventory.data.base;

import android.content.ContentValues;

import com.example.inventory.data.model.Product;
import com.example.inventory.data.model.ProductInner;

import java.util.ArrayList;

/**
 * Created by Miguel on 08/02/2018.
 */

public interface ProductDao {
    ArrayList<Product> loadAll();
    boolean exists(Product product);
    long add(Product product);
    int update(Product product);
    int delete(Product product);
    ProductInner search(int id);
    ContentValues CreateContent(Product product);
}
