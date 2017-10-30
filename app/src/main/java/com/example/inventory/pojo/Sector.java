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

    private int ID;
    private String name;
    private String sortname;
    private String description;
    private int dependencyID;
    private boolean enabled;
    private boolean _default;

    public Sector(int ID, String name, String sortname, String description, int dependencyID, boolean enabled, boolean _default) {
        this.ID = ID;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
        this.dependencyID = dependencyID;
        this.enabled = enabled;
        this._default = _default;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }
}
