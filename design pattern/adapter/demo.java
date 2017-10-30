package com.liu.programminglearning.designpattern.adapter;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class demo {
    public static void use(){
        Adapter adapter1 = new Adapter(new Adaptee());
        adapter1.request();
    }
}
