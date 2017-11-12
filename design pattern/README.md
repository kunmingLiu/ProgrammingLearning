Solid原則：

## 單一職責原則(Single Responsibility Principle)
一個類別最好只負責單一職責就好，如果讓單一類別負責太多職責的話，不只程式碼會相當龐大，日後要維護也相當困難。

## 開閉原則(Open Closed Principle)
對擴展開放，對修改關閉。因為當去修改本來程式碼的時候，很容易引發出本來沒有的bug(可能眼殘或是手殘改錯地方，導致本來跑的好好的程式突然就掛掉了)，所以儘可能不要去修改本來的程式碼，而是用其他如繼承的方式來完成新的需求。 

## 里氏替換原則(Liskov Substitution Principle LSP)
If for each object o1 of type S there is an object o2 of type T such that for all programs P defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a subtype of T. 

Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it. 
###### 以下是對LSP自己的解讀
    private void fly(Bird bird){
        System.out.print("Bird can fly");    
    }
    private void fly(Eagle eagle){
        System.out.print("Eagle can fly");
    }
    當今天將鳥類(Bird)改成老鷹(Eagle)後，可以發現整個程式的行為是不會有所改變的，
    因為不管是鳥類(Bird)或是老鷹(Eagle)都是會飛的。
    那麼以LSP來說，就可以說老鷹(Eagle)是鳥類(Bird)的子類別。
    
    那如果今天是把鳥類(Bird)替換成老虎(Tiger)後，程式的行為就會有改變了，因為老虎(Tiger)是不會飛的，
    因此以LSP來說，老虎(Tiger)就不是鳥類(Bird)的子類別。
    
    LSP第二點提到：所有引用父類別的地方必須能透明地使用其子類的對象。
    pulbic class Eagle extends Bird{....}
    如果某個類別中，有個method如下
    private void printFly(Bird bird){
        bird.fly();
    }
    當我們傳入Eagle的變數當作參數的時候
    printFly(new Eagle());
    會發現印出來的結果會是Eagle can fly，而不是Bird can fly，因為引用父類別的地方(Bird)必須能透明地使用其子類的對象(Eagle)。
    至於第二點的部分，其實就是物件導向中多型的概念。
    
## 依賴倒置原則(Dependency Inversion Principle)
高層模塊不應該依賴低層模塊，二者都應該依賴其抽象；抽象不應該依賴細節；細節應該依賴抽象。
#### 以果汁來做例子
###### 因為高層模塊依賴低層模塊(AppleJuice,BananaJuice)，因此就必須寫上兩個不同參數卻又做相同事情的method
    //高層模塊
    private void printFruitAndPrice(AppleJuice juice){
        Log.e("Juice", juice.getFruit()+" $"+juice.getPrice());
    }

    private void printFruitAndPrice(BananaJuice juice){
        Log.e("Juice", juice.getFruit()+" $"+juice.getPrice());
    }
###### 高層模塊與低層模塊都去依賴抽象(Juice)，那就只需要寫一個method，而不同種的果汁都可以共用
    public abstract class Juice {
        abstract String getFruit();
        abstract int getPrice();
    }
    //BananaJuice同樣也extends Juice
    public class AppleJuice extends Juice{
        public String getFruit(){
            return "Apple";
        }
        public int getPrice(){
            return 50;
        }
    }
    //高層模塊
    private void printFruitAndPrice(Juice juice){
        Log.e("Juice", juice.getFruit()+" $"+juice.getPrice());
    }
    
## 介面隔離原則(Interface Segregation Principle)
拆分非常龐大臃腫的接口成為更小的和更具體的接口。
###### 如果讓接口去包山包海的，那所有實作這接口的類別都必須要去實做一些自己根本就不需要的method。     
    以下為不遵守ISP原則的例子：
    因為考慮到動物裡面有些會飛、有些會跑、有些會游泳，因此我們將接口設定成為
    public interface animal{
        void run();
        void fly();
        void swim();
    }
    public class Tiger implements animal{
        @override
        public void run(){
            //do somethig
        }
        @override
        public void fly(){
            //nothing
        }
        @override
        public void swim(){
            //nothing
        }        
    }
    由上面的例子可以發現，明明老虎是不會飛而且也不會游泳，但是為了要去遵守animal的接口，還是得必須去實做fly()跟swim()。
    這就是因為animal接口太過於龐大的關係。
    
    但是也切記不要矯枉過正，把接口拆得太細小，這樣的話每個類別都要去實做很多個接口。

