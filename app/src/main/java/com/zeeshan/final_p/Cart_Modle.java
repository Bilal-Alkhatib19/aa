package com.zeeshan.final_p;

import android.graphics.Bitmap;

public class Cart_Modle {
    private String price_cart;
    private int id_cart;
    private String name_cart;
    private String quntity_cart;
    private Bitmap image_cart;

    public Cart_Modle(String price_cart, String name_cart, String quntity_cart, Bitmap image_cart) {
        this.price_cart = price_cart;
        this.name_cart = name_cart;
        this.quntity_cart = quntity_cart;
        this.image_cart = image_cart;
    }
    public Cart_Modle(String price_cart, String name_cart, String quntity_cart) {
        this.price_cart = price_cart;
        this.name_cart = name_cart;
        this.quntity_cart = quntity_cart;
    }

public String getPrice_cart() {
        return price_cart;
    }

    public void setPrice_cart(String price_cart) {
        this.price_cart = price_cart;
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public String getName_cart() {
        return name_cart;
    }

    public void setName_cart(String name_cart) {
        this.name_cart = name_cart;
    }

    public String getQuntity_cart() {
        return quntity_cart;
    }

    public void setQuntity_cart(String quntity_cart) {
        this.quntity_cart = quntity_cart;
    }

    public Bitmap getImage_cart() {
        return image_cart;
    }

    public void setImage_cart(Bitmap image_cart) {
        this.image_cart = image_cart;
    }
}
