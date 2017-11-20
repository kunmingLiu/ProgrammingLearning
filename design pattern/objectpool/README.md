# 物件池(Object Pool)
## 定義
### 1.將物件的實例統一做管理。
    當外部程式需要的時候，必須要來跟物件池拿一個實例去用。不得讓外部程式自己去建立實例。
    當外部程式用完的時候，必須歸還給物件池。

### 2.當物件池中的實例不夠用的時候，才會新建一個實例出來 ; 若池中有沒有再用的實例的話，就直接拿沒用的實例給外部用。


## 使用時機
### 1.當類的創建過程相當繁瑣或是耗資源時，不應該任由外部任意地去創建實例。
### 2.當類可以交互使用時(A用完，換B用)。
--------------------------------------
#### 以保齡球鞋子做例子。當發現有沒用的鞋子的話，可以直接拿這雙鞋子給客人。
##### Shoes類別 
	public class Shoes {
		private int size;
		private int color;
	
		public int getSize() {
			return size;
		}
	
		public void setSize(int size) {
			this.size = size;
		}
	
		public int getColor() {
			return color;
		}
	
		public void setColor(int color) {
			this.color = color;
		}
	}
##### Shoes Pool
###### 1.用兩個集合分別記錄正在用(inUse)跟沒有在用(available)。
###### 2.當客人要鞋子(acquireShoes)的時候，先看available有沒有沒有再用的鞋子，如果有直接給客人; 若沒有的話，則直接創建一個新的實例給客人。
###### 3.當客人要鞋子(acquireShoes)或是還鞋子(releaseShoes)的時候，都要修改available跟inUse的資料。
###### 4.加入synchronized確保線程的安全性。
	public class ShoesPool {
		private Set<Shoes> available ;
		private Set<Shoes> inUse ;
	
		public ShoesPool() {
			available = new HashSet<>();
			inUse = new HashSet<>();
		}
	
		private Shoes createShoes(){
			return new Shoes();
		}
		public synchronized Shoes acquireShoes(){
			if(available.isEmpty()){
				available.add(createShoes());
			}
			Shoes shoes = available.iterator().next();
			available.remove(shoes);
			inUse.add(shoes);
			return shoes;
		}
		public synchronized  void releaseShoes(Shoes shoes){
			inUse.remove(shoes);
			available.add(shoes);
		}
	}
    
------------------------------------
##  參考網站

https://sourcemaking.com/design_patterns/object_pool/java
