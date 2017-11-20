package com.liu.programminglearning.designpattern.objectpool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class ShoesPool {
    private Set<Shoes> available ;
    private Set<Shoes> inUse ;

    public ShoesPool() {
        available = new HashSet<>();
        inUse = new HashSet<>();
    }

    private Shoes createShoes(){
        return new Shoes();
    }
    public synchronized Shoes acquireShoes(){
        if(available.isEmpty()){
            available.add(createShoes());
        }
        Shoes shoes = available.iterator().next();
        available.remove(shoes);
        inUse.add(shoes);
        return shoes;
    }
    public synchronized  void releaseShoes(Shoes shoes){
        inUse.remove(shoes);
        available.add(shoes);
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}

