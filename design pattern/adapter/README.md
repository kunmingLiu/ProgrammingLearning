# 轉接器模式(Adapter Pattern)
## 定義
將一個類別的介面，轉換成另一個介面以供客戶使用。轉接器讓原本介面不相容的類別可以合作。

## 使用時機
當目前的介面與Target的介面不相容時。

-------------------------------------------------------
#### Target的介面
    public interface Target  {
        void request();
    }
#### 目前的類
    public class Adaptee {
        public void sendRequest(){
    
        }
    }
###### 1.目前的類Adaptee與Target的介面是不相容的。
###### 2.雖然可以修改Adaptee，讓其實作Target介面，這樣就彼此相容了;但是這種作法違反了開閉原則，而且如果此類要相容10種不同的Target介面，不可能每一種介面都去實作。

#### 新建Adapter
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
###### 1.讓Adapter去實作Target介面，那Adapter與Target就相容了。
###### 2.讓Adapter去依賴Adaptee，而在Target介面的method中去使用Adaptee的method。
###### 3.客戶等於是透過Adapter去使用本來的Adaptee。

----------------------------------
## 參考網站

https://dotblogs.com.tw/pin0513/2010/05/30/15497

http://www.oodesign.com/adapter-pattern.html
