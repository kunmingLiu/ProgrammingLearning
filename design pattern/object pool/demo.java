package com.liu.programminglearning.designpattern.objectpool;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class demo {
    public static void use(){
        ShoesPool shoesPool = new ShoesPool();
        System.out.print("shoesPool count : " + shoesPool.toString());

        Shoes shoes1 = shoesPool.acquireShoes();
        System.out.print( "shoes1 : "+ shoes1.toString());
        System.out.print("after acquire 1 shoesPool count : " + shoesPool.toString());



        Shoes shoes2 = shoesPool.acquireShoes();
        System.out.print( "shoes2 : "+ shoes1.toString());
        System.out.print("after acquire 2 shoesPool count : " + shoesPool.toString());

        Shoes shoes3 = shoesPool.acquireShoes();
        System.out.print( "shoes3 : "+ shoes1.toString());
        System.out.print("after acquire 3 shoesPool count : " + shoesPool.toString());

        shoesPool.releaseShoes(shoes1);
        System.out.print("after release 1 shoesPool count : " + shoesPool.toString());

        shoesPool.releaseShoes(shoes2);
        System.out.print("after release 2 shoesPool count : " + shoesPool.toString());

        Shoes shoes4 = shoesPool.acquireShoes();
        System.out.print( "shoes4 : "+ shoes1.toString());
        System.out.print("after acquire 4 shoesPool count : " + shoesPool.toString());

        Shoes shoes5 = shoesPool.acquireShoes();
        System.out.print( "shoes5 : "+ shoes1.toString());
        System.out.print("after acquire 5 shoesPool count : " + shoesPool.toString());

        Shoes shoes6 = shoesPool.acquireShoes();
        System.out.print( "shoes6 : "+ shoes1.toString());
        System.out.print("after acquire 6 shoesPool count : " + shoesPool.toString());
    }
}
