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