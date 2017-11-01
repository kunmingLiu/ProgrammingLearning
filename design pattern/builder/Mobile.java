package com.liu.myapplication;

/**
 * Created by kunmingliu on 2017/11/1.
 */

public class Mobile implements Cloneable{
    public static int IOS = 0;
    public static int ANDROID = 1;
    private int os; //作業系統
    private String brand;//品牌
    private int size;//大小
    private int color;//顏色
    private int version;//版本

    public int getOs() {
        return os;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public int getColor() {
        return color;
    }

    public int getVersion() {
        return version;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    static class Builder{
        Mobile mobile = new Mobile();

        Builder setOS(int os){
            mobile.os = os;
            return this;
        }
        Builder setBrand(String brand){
            mobile.brand = brand;
            return this;
        }
        Builder setSize(int size){
            mobile.size = size;
            return this;
        }
        Builder setColor(int color){
            mobile.color = color;
            return this;
        }
        Builder setVersion(int version){
            mobile.version = version;
            return this;
        }
        Mobile build(){
            try {
                return (Mobile) mobile.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return mobile;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
