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
