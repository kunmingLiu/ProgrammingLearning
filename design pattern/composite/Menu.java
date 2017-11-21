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
