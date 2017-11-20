# 工廠方法模式（Factory Pattern）

### 1.將工廠抽象化，讓每個產品都有各自的工廠。
### 2.當要增加新產品時，只要新增一個新工廠即可，並不會影響到本來的程式碼，這解決了簡單工廠擴充的問題。

## 問題
### 1.如果新產品太多的話，會導致程式擁有太多工廠類。
--------------------------------------
![image](https://github.com/kunmingLiu/MyPicture/blob/master/factory%20method.png)
參考圖片來源 : http://www.oodesign.com/factory-pattern.html

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

###### 果汁工廠的抽象類別
  public abstract class Juice {
      public abstract String getName();
      public abstract int getPrice();
  }

###### 負責生產AppleJuice的工廠
  public class AppleJuiceFactory extends JuiceFactory {
      @Override
      public Juice getJuice() {
          return new AppleJuice();
      }
  }

###### 負責生產OrangeJuice的工廠
  public class OrangeJuiceFactory extends JuiceFactory {
      @Override
      public Juice getJuice() {
          return new OrangeJuice();
      }
  }

###### 用法
  JuiceFactory factory = null;

  factory = new AppleJuiceFactory();
  Juice appleJuice = factory.getJuice();

  factory = new OrangeJuiceFactory();
  Juice orangeJuice = factory.getJuice();

###### 增加新產品KiwiJuice(不會影響到其他工廠的運行)
  factory = new KiwiJuiceFactory();
  Juice kiwiJuice = factory.getJuice();          

    
------------------------------------
##  參考網站

https://rongli.gitbooks.io/design-pattern/content/chapter2.html
