# 組合模式(Composite Pattern)
## 定義
將物件以樹形結構組織起來,以達成“部分－整體” 的層次結構，使得用戶端對單個物件和組合物件的使用具有一致性。

## 使用時機
當物件本身就是一種樹形結構

-------------------------------------------------------
![image](https://github.com/kunmingLiu/MyPicture/blob/master/decorator.png)
參考圖片來源 : https://en.wikipedia.org/wiki/Composite_pattern

### 以百貨公司的衣服DM來當作例子，DM架構如下圖。

###### 由上圖可以知道子項也有可能是個選單，而選單再往下衍生出其他品項
###### 組合模式中最重要的關鍵就是要把選單跟品項視為是同一類(抽象)，這樣使用者使用的時候才不需要考慮目前處理的這個倒底是選單還是品項。

#### AbstractMenu的抽象
    public abstract class AbstractMenu {
        protected String name = null;
    
        public AbstractMenu(String name) {
            this.name = name;
        }
    
        public abstract void add(AbstractMenu menu);
        public abstract void remove(AbstractMenu menu);
        public abstract AbstractMenu getChild(int index);
        public abstract void print();
    }

#### 選單的類(當中會宣告一個集合去記錄自己下面的品項)
    public class Menu extends AbstractMenu {
        private List<AbstractMenu> menuList = new ArrayList<>();
    
        public Menu(String name) {
            super(name);
        }
    
        @Override
        public void add(AbstractMenu menu) {
            menuList.add(menu);
        }
    
        @Override
        public void remove(AbstractMenu menu) {
            menuList.remove(menu);
        }
    
        @Override
        public AbstractMenu getChild(int index) {
            return menuList.get(index);
        }
    
        @Override
        public void print() {
            System.out.print("Menu name : "+name);
            for (AbstractMenu menu: menuList
                 ) {
                menu.print();
            }
        }
    }

#### 品項的類
    public class Clothes extends AbstractMenu {
        public Clothes(String name) {
            super(name);
        }
    
        @Override
        public void add(AbstractMenu menu) {
            //no thing
        }
    
        @Override
        public void remove(AbstractMenu menu) {
            //no thing
        }
    
        @Override
        public AbstractMenu getChild(int index) {
            return null;
        }
    
        @Override
        public void print() {
            System.out.print("Clothes name : "+name);
        }
    }


#### 用法   
    AbstractMenu mainMenu = new Menu("衣服DM");
    AbstractMenu hamMenu = new Menu("HAM DM");
    AbstractMenu nikeMenu = new Menu("NIKE DM");
    AbstractMenu kobeMenu = new Menu("Kobe球衣總覽");
    
    AbstractMenu blackClothes = new Clothes("黑色上衣");
    AbstractMenu whiteClothes = new Clothes("白色上衣");
    AbstractMenu curryClothes = new Clothes("Curry球衣");
    AbstractMenu kobe24Clothes = new Clothes("Kobe24號球衣");
    AbstractMenu kobe8Clothes = new Clothes("Kobe8號球衣");
    
    hamMenu.add(blackClothes);
    hamMenu.add(whiteClothes);
    
    kobeMenu.add(kobe8Clothes);
    kobeMenu.add(kobe24Clothes);
    
    nikeMenu.add(curryClothes);
    nikeMenu.add(kobeMenu);
    
    mainMenu.add(hamMenu);
    mainMenu.add(nikeMenu);
    
    mainMenu.print();
----------------------------
    Menu name : 衣服DM
    Menu name : HAM DM
    Clothes name : 黑色上衣
    Clothes name : 白色上衣
    Menu name : NIKE DM
    Clothes name : Curry球衣
    Menu name : Kobe球衣總覽
    Clothes name : Kobe8號球衣
    Clothes name : Kobe24號球衣

----------------------------------
## 參考網站

http://xyz.cinc.biz/2013/07/composite-pattern.html
