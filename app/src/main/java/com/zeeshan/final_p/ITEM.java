package com.zeeshan.final_p;

public class ITEM {
    String name;
    String price;
    int image;
    int imageCart;
    String dic;
    String qaun;


    public ITEM(String name, String price, int image, int imageCart, String dic, String qaun) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.imageCart = imageCart;
        this.dic = dic;
        this.qaun = qaun;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageCart() {
        return imageCart;
    }

    public void setImageCart(int imageCart) {
        this.imageCart = imageCart;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getQaun() {
        return qaun;
    }

    public void setQaun(String qaun) {
        this.qaun = qaun;
    }
}
