public class Bubble extends DrinkDecorator {
    public Bubble(Drink drink) {
        super(drink);
    }

    @Override
    public int getPrice() {
        return drink.getPrice()+ 5;
    }

    @Override
    public String getComponent() {
        return drink.getComponent()+" + 珍珠";
    }
}
