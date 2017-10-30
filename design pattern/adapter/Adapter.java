package com.liu.programminglearning.designpattern.adapter;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class Adapter implements Target {
    private Adaptee adpatee;

    public Adapter(Adaptee adpatee) {
        this.adpatee = adpatee;
    }

    @Override
    public void request() {
        adpatee.sendRequest();
    }
}
