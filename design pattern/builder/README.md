# 建造者模式(Builder Pattern)
## 定義
#### 將一個複雜對象的構造與它的表示分離，使得同樣的構造過程可以創建不同的表示。

## 使用時機
#### 1.當某一類有很多method，而且呼叫method的順序不同，而會有不同的結果時。
#### 2.當某一類有些method，只能在初始化時能使用，其餘時候不能使用時。

-----------------------------
##### 以煮飯當作例子來說，正確的順序是洗米->放入電鍋蒸
###### 未使用Builder Pattern
    public class CookRice {
        public void wash(int water){
            System.out.print("加入"+water+"毫升水，開始洗米");
        }
        public void steam(int minute){
            System.out.print("電鍋設定"+minute+"分鐘，開始煮飯");
        }
    }
    //若method呼叫的順序不對，那就不能吃到好吃的飯了。
    CookRice cookRice = new CookRice();
    cookRice.steam(30);
    cookRice.wash(1000);
    
###### 使用Builder Pattern
    public class CookRice {
        private int water;
        private int minute;
        private CookRice(){
    
        }
        private CookRice(int water , int minute){
            this.water = water;
            this.minute = minute;
        }
        static class Builder{
            private int water;
            private int minute;
            public Builder wash(int water){
              this.water = water;
              return this;
            }
            public Builder steam(int minute){
              this.minute = minute;
              return this;
            }
            public CookRice build(){
                System.out.print("加入"+water+"毫升水，開始洗米");
                System.out.print("電鍋設定"+minute+"分鐘，開始煮飯");
                return new CookRice(water , minute);
            }
        }
    }
    //不管呼叫method的順序為何，都能確保最後的結果是正確的
    CookRice cookRice = new CookRice.Builder().wash(1000).steam(30).build();
    CookRice cookRice = new CookRice.Builder().steam(30).wash(1000).build();
   
    
