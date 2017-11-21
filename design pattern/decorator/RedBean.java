public class RedBean extends DrinkDecorator {
    public RedBean(Drink drink) {
        super(drink);
    }

    @Override
    public int getPrice() {
        return drink.getPrice()+ 15;
    }

    @Override
    public String getComponent() {
        return drink.getComponent()+" + 紅豆";
    }
}