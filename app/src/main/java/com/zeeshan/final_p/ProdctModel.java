package com.zeeshan.final_p;

import android.graphics.Bitmap;

import java.util.Arrays;

public class ProdctModel {

    public ProdctModel() {

    }

    private int id;
    private String name;
    private String price;
    private String qun;
    private String dic;
    private Bitmap image;



    public ProdctModel(String name, String price, String qun, String dic, Bitmap image) {
        this.name = name;
        this.price = price;
        this.qun = qun;
        this.dic = dic;
        this.image = image;
    }
    public ProdctModel(String name, String price, String qun, String dic) {
        this.name = name;
        this.price = price;
        this.qun = qun;
        this.dic = dic;
    }
    public ProdctModel(String name, String price, String qun, String dic,Bitmap image,int id) {
        this.name = name;
        this.price = price;
        this.qun = qun;
        this.dic = dic;
        this.image = image;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQun() {
        return qun;
    }

    public void setQun(String qun) {
        this.qun = qun;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProdctModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", qun='" + qun + '\'' +
                ", dic='" + dic + '\'' +
                ", image=" + image +
                '}';
    }
}
