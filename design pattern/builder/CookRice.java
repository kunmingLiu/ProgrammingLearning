public class CookRice {
    private int water;
    private int minute;
    private int source;
    private CookRice(){

    }
    private CookRice(int water , int minute){
        this.water = water;
        this.minute = minute;
    }

    public void addSource(int source){
        System.out.print("加入"+source+"醬料");
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
