# 簡單工廠(Simple Factory or Static Factory)

### 1.定義一個工廠，傳入不同的參數取得不同的類別物件。
### 2.隱藏物件的創建過程，使用者只需要指導自己需要什麼就好，不需要知道要如何創建。

## 問題
### 1.未來要擴充時，需要修改factory的程式碼，這違反了開閉原則。
--------------------------------------
##### 以果汁來做例子
###### 果汁的抽象類別
    public abstract class Juice {
        public abstract String getName();
        public abstract int getPrice();
    }

###### Apple Juice
    public class AppleJuice extends Juice {
        @Override
        public String getName() {
            return "Apple";
        }

        @Override
        public int getPrice() {
            return 50;
        }
    }

###### Orange Juice
    public class OrangeJuice extends Juice {
        @Override
        public String getName() {
            return "Orange";
        }
    
        @Override
        public int getPrice() {
            return 60;
        }
    }

###### JuiceFactory
    public class JuiceFactory {
       public final static int APPLE_JUICE = 0;
       public final static int ORANGE_JUICE = 1;
       public static Juice getJuice(int type){
           switch (type){
               case APPLE_JUICE:
                   return new AppleJuice();
               case ORANGE_JUICE:
                   return new OrangeJuice();
               default:
                   throw new IllegalArgumentException("沒有這種果汁");
           }
        }
    }

###### 用法
    Juice appleJuice = JuiceFactory.getJuice(JuiceFactory.APPLE_JUICE);
    Juice orangeJuice = JuiceFactory.getJuice(JuiceFactory.ORANGE_JUICE);

    
------------------------------------
##  參考網站

https://skyyen999.gitbooks.io/-study-design-pattern-in-java/content/simpleFactory.html
