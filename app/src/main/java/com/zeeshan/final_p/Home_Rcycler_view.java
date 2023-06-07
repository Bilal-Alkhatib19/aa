package com.zeeshan.final_p;

public class Home_Rcycler_view {
    private String name;
    private String price;
    private byte [] iamge;
    int imageCart;
    String dic;
    String qaun;

    public Home_Rcycler_view(String name, String price, byte[] iamge, int imageCart, String dic, String qaun) {
        this.name = name;
        this.price = price;
        this.iamge = iamge;
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

    public byte[] getIamge() {
        return iamge;
    }

    public void setIamge(byte[] iamge) {
        this.iamge = iamge;
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
