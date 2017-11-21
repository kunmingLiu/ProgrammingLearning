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
