# 裝飾者模式(Decorator Pattern)
## 定義
動態地將責任加諸於物件上，若要擴充功能，裝飾者提供了比繼承更有彈性的選擇！

-------------------------------------------------------
![image](https://github.com/kunmingLiu/MyPicture/blob/master/factory%20method.png)
參考圖片來源 : https://en.wikipedia.org/wiki/Decorator_pattern

### 以手搖杯店的奶茶當作例子。可以單獨地賣奶茶本身，當然也可以選擇添加配料，只是若添加不同種的配料，價格與成分上就會有所差異。
#### Drink的抽象
    public abstract class Drink  {
        public abstract int getPrice();
        public abstract String getComponent();
    }
#### 奶茶的類
    public class MilkTea extends Drink {
        @Override
        public int getPrice() {
            return 50;
        }
    
        @Override
        public String getComponent() {
            return "牛奶 + 茶";
        }
    }

#### 配料的抽象
    public abstract class DrinkDecorator extends Drink {
        protected Drink drink;
    
        public DrinkDecorator(Drink drink) {
            this.drink = drink;
        }
    
    }
###### 讓配料去依賴飲品(Drink)，配料要跟飲品一起出現才有意義。

#### 配料珍珠的類
    public class Bubble extends DrinkDecorator {
        public Bubble(Drink drink) {
            super(drink);
        }
    
        @Override
        public int getPrice() {
            return drink.getPrice()+ 5;
        }
    
        @Override
        public String getComponent() {
            return drink.getComponent()+" + 珍珠";
        }
    }

#### 配料布丁的類
    public class Pudding extends DrinkDecorator {
        public Pudding(Drink drink) {
            super(drink);
        }
    
        @Override
        public int getPrice() {
            return drink.getPrice()+ 10;
        }
    
        @Override
        public String getComponent() {
            return drink.getComponent()+" + 布丁";
        }
    }    

#### 用法   
    Drink milkTea = new MilkTea();
    milkTea = new Bubble(milkTea);
    System.out.print("價格 : "+milkTea.getPrice()+" 成分 : "+milkTea.getComponent());//價格 : 55 成分 : 牛奶 + 茶 + 珍珠
    milkTea = new Pudding(milkTea);
    System.out.print("價格 : "+milkTea.getPrice()+" 成分 : "+milkTea.getComponent());//65 成分 : 牛奶 + 茶 + 珍珠 + 布丁

----------------------------------
## 參考網站

https://dotblogs.com.tw/pin0513/archive/2010/01/04/12779.aspx