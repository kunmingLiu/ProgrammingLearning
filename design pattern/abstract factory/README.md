# 抽象工廠模式（Abstract Factory Pattern）

### 1.與工廠方法類似，但是抽象工廠用來同時生產一系列的產品。

--------------------------------------
![image](https://github.com/kunmingLiu/MyPicture/blob/master/factory%20method.png)
參考圖片來源 : https://en.wikipedia.org/wiki/Abstract_factory_pattern

##### 以電腦的滑鼠跟鍵盤來做例子
###### 滑鼠的抽象類別
  public abstract class Mouse {
      public abstract void leftClick();
      public abstract void rightClick();
  }

###### 鍵盤的抽象類別
  public abstract class Keyboard {
      public abstract void typeChar();
      public abstract void typeNumber();
  }

###### ComputerFactory的抽象類別。生產一台Computer時，要同時生產其滑鼠跟鍵盤
  public abstract class ComputerFactory {
      public abstract Mouse getMouse();
      public abstract Keyboard getKeyboard();
  }

###### ApplePCFactory。用來專門生產Apple的電腦，生產電腦的同時也要生產這台Apple電腦用的滑鼠跟鍵盤。而Apple電腦當然是選擇用自家產品的滑鼠跟鍵盤。
  public class ApplePCFactory extends ComputerFactory {
      @Override
      public Mouse getMouse() {
          return new AppleMouse();
      }
  
      @Override
      public Keyboard getKeyboard() {
          return new AppleKeyboard();
      }
  }

###### AsusPCFactory。用來專門生產Asus的電腦
  public class AsusPCFactory extends ComputerFactory {
      @Override
      public Mouse getMouse() {
          return new AsusMouse();
      }
  
      @Override
      public Keyboard getKeyboard() {
          return new AsusKeyboard();
      }
  }

###### 用法
  omputerFactory applePCFactory = new ApplePCFactory();
  pplePCFactory.getMouse().leftClick();
  pplePCFactory.getKeyboard().typeChar();

  omputerFactory asusPCFactory = new AsusPCFactory();
  susPCFactory.getMouse().leftClick();
  susPCFactory.getKeyboard().typeChar();    

    
------------------------------------
##  參考網站

https://rongli.gitbooks.io/design-pattern/content/chapter3.html

http://www.oodesign.com/abstract-factory-pattern.html
