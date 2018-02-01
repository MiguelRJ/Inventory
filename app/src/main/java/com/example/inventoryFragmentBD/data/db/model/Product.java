package com.example.inventoryFragmentBD.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Miguel on 30/01/2018.
 */

public class Product implements Parcelable {

    public static String TAG = "product";
    private int _id;
    private String name;
    private String serial;
    private String seller;
    private String model;
    private Categorie categorie;
    private Type type;
    private String description;
    private float price;
    private Date buyDate;
    private String url;
    private String notes;

    public Product(int _id, String name, String serial, String seller, String model, Categorie categorie, Type type, String description, float price, Date buyDate, String url, String notes) {
        this._id = _id;
        this.name = name;
        this.serial = serial;
        this.seller = seller;
        this.model = model;
        this.categorie = categorie;
        this.type = type;
        this.description = description;
        this.price = price;
        this.buyDate = buyDate;
        this.url = url;
        this.notes = notes;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_id);
        parcel.writeString(name);
        parcel.writeString(serial);
        parcel.writeString(seller);
        parcel.writeString(model);
        parcel.writeString(description);
        parcel.writeFloat(price);
        parcel.writeString(url);
        parcel.writeString(notes);
    }

    protected Product(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        serial = in.readString();
        seller = in.readString();
        model = in.readString();
        description = in.readString();
        price = in.readFloat();
        url = in.readString();
        notes = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
