package com.example.inventory.data.base;

import android.content.ContentValues;

import com.example.inventory.data.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public interface DependencyDao {
    ArrayList<Dependency> loadAll();
    boolean exists(Dependency dependency);
    long add(Dependency dependency);
    int update(Dependency dependency);
    int delete(Dependency dependency);
    ContentValues CreateContent(Dependency dependency);
}
