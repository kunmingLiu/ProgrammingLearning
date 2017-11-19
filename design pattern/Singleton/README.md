# 單例模式(Singleton)
### 1.就算在多線程的情況下，也能確保類只會有一個實例。

### 2.提供static method讓外部的程式能夠取得該實例。(不讓外部可以使用該類的constructor)
--------------------------------------
##### 不考慮空間浪不浪費的寫法
###### 不管有沒有人是真的需要該實例，只要該類被使用的，立刻就把該實例給new出來
    class Singleton {
        private static final Singleton ourInstance = new Singleton();
    
        static Singleton getInstance() {
            return ourInstance;
        }
    
        private Singleton() {
        }
    }

##### 單線程的寫法
###### 當getInstance()被呼叫到了，才會去將實例給new出來，這樣就不會白白new出來，但是沒有人用
    class Singleton {
        private static Singleton ourInstance;
    
        static Singleton getInstance() {
            if(ourInstance == null){
                ourInstance = new Singleton();
            }
            return ourInstance;
        }
    
        private Singleton() {
        }
    }
    
##### 多線程的寫法
###### 在synchronized外面多做一個判斷，當ourInstance==null時，才去做synchronized;不然每次呼叫getInstance()都要做synchronized，效率會比較慢一點。
    class Singleton {
        private volatile static Singleton ourInstance;
    
        static Singleton getInstance() {
            if(ourInstance == null){
                synchronized (Singleton.class){
                    if(ourInstance == null){
                        ourInstance = new Singleton();
                    }
                }
            }
            return ourInstance;
        }
        private Singleton() {
        }
    }

##### 結合第一種與第二種寫法
###### 不只解決了第一種浪費空間的問題，也解決了第二種不能確保線程安全的問題
    public class Singleton {
        private static class SingletonHolder{
            private static Singleton instance= new Singleton ();
        }
    
        private Singleton () {
    
        }
        public static Singleton getInstance(){
            return SingletonHolder.instance;
        }
    }
  
##### enum的寫法，也能確保線程的安全性
    enum Singleton {
        INSTANCE;
        Singleton() {
            System.out.println("Singleton constructor");
        }
        public void dowork() {
            System.out.println(" do work ");
        }
    }
###### 用法  
    Singleton.INSTANCE.dowork();
    
------------------------------------
##  參考網站
http://blog.csdn.net/card361401376/article/details/51340822
http://blog.csdn.net/huachao1001/article/details/51536074
