package com.example.inventory.data.provider.dao;

import android.content.ContentValues;

import com.example.inventory.data.base.DependencyDao;
import com.example.inventory.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyProviderDaoImpl implements DependencyDao {

    @Override
    public ArrayList<Dependency> loadAll() {
        return null;
    }

    @Override
    public boolean exists(Dependency dependency) {
        return false;
    }

    @Override
    public long add(Dependency dependency) {
        return 0;
    }

    @Override
    public int update(Dependency dependency) {
        return 0;
    }

    @Override
    public int delete(Dependency dependency) {
        return 0;
    }

    @Override
    public ContentValues CreateContent(Dependency dependency) {
        return null;
    }
}
