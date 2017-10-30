package com.example.inventory.pojo;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          Sector
 * @date 30/10/17
 */

public class Sector {

    private int _ID;
    private String name;
    private String sortname;
    private String description;
    private int dependencyID;
    private boolean enabled;
    private boolean sectorDefault;

    public Sector(int ID, String name, String sortname, String description, int dependencyID, boolean enabled, boolean _default) {
        this._ID = ID;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
        this.dependencyID = dependencyID;
        this.enabled = enabled;
        this.sectorDefault = _default;
    }

    public int getID() {
        return _ID;
    }

    public void setID(int ID) {
        this._ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDependencyID() {
        return dependencyID;
    }

    public void setDependencyID(int dependencyID) {
        this.dependencyID = dependencyID;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isSectorDefault() {
        return sectorDefault;
    }

    public void set_default(boolean _default) {
        this.sectorDefault = _default;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", sortname='" + sortname + '\'' +
                ", description='" + description + '\'' +
                ", dependencyID=" + dependencyID +
                ", enabled=" + enabled +
                ", _default=" + sectorDefault +
                '}';
    }
}
