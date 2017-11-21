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
