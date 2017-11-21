# 橋接模式（Bridge Pattern）

## 定義
### 將抽象部分與它的實現部分分離，使它們都可以獨立地變化。

## 使用時機
### 1.當變化維度超過二維時

--------------------------------------
![image](https://github.com/kunmingLiu/MyPicture/blob/master/bridge.png)
參考圖片來源 : https://en.wikipedia.org/wiki/Bridge_pattern

##### 以早餐店做例子，若麵包可以選擇吐司或是貝果、果醬可以選擇巧克力跟花生，所以一共會有四種排列組合。
###### 若不用橋接模式的話，以這個例子來說可能每種變化都需要有其對應的類別(如：巧克力土司類、花生吐司類、巧克力貝果類、花生貝果類)

###### Jam的抽象類別
    public abstract class Jam {
        public abstract String getJam();
    }


###### Bread的抽象類別
    public abstract class Bread {
        protected Jam jam = null;
    
        public Bread(Jam jam) {
            this.jam = jam;
        }
        public abstract String getBread();
        public String getFullName(){
            return jam.getJam()+getBread();
        }
    }


###### 巧克力果醬的類
    public class ChocolateJam extends Jam {
        @Override
        public String getJam() {
            return "巧克力";
        }
    }


###### 花生果醬的類
    public class PeanutJam extends Jam {
        @Override
        public String getJam() {
            return "花生";
        }
    }


###### 貝果的類
    public abstract class Bread {
        protected Jam jam = null;
    
        public Bread(Jam jam) {
            this.jam = jam;
        }
        public abstract String getBread();
        public String getFullName(){
            return jam.getJam()+getBread();
        }
    }

###### 吐司的類
    public class Toast extends Bread {
        public Toast(Jam jam) {
            super(jam);
        }
    
        @Override
        public String getBread() {
            return "吐司";
        }
    }


###### 用法
    Bread toast = new Toast(new ChocolateJam());//巧克力吐司
    toast = new Toast(new PeanutJam());//花生吐司

    Bread bagel = new Bagel(new PeanutJam());//花生貝果
    bagel = new Bagel(new ChocolateJam());//巧克力貝果

    
------------------------------------
##  參考網站

https://rongli.gitbooks.io/design-pattern/content/chapter7.html
