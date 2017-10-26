package com.example.inventory.pojo;

/**
 * Created by usuario on 25/10/17.
 */

public class Dependency {
    private int _ID;
    private String name;
    private String sortName;
    private String description;

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String shortame) {
        this.sortName = shortame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dependency(int _ID, String name, String shortame, String description) {

        this._ID = _ID;
        this.name = name;
        this.sortName = shortame;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", shortame='" + sortName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
