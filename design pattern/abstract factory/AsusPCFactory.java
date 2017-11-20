public class AsusPCFactory extends ComputerFactory {
    @Override
    public Mouse getMouse() {
        return new AsusMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new AsusKeyboard();
    }
}