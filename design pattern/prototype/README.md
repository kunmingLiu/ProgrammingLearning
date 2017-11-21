# 原型模式(Prototype Pattern)
## 定義
簡單的說，就是複製

## 使用時機
若某類創建實例過程相當複雜且耗資源，那若需要多個實例時，應該避免使用new，還是改用clone()。

-------------------------------------------------------
##### Prototype的抽象
    public abstract class Prototype implements Cloneable {
        public Prototype clone() throws CloneNotSupportedException{
            return (Prototype) super.clone();
        }
    }

##### ConcretePrototype1的類
    public class ConcretePrototype1 extends Prototype {
        @Override
        public Prototype clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

##### 用法
    ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
    try {
        Prototype concretePrototype2 = concretePrototype1.clone();
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }    
----------------------------------
## 參考網站

https://en.wikipedia.org/wiki/Prototype_pattern