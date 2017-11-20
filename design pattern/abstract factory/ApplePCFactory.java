public class ApplePCFactory extends ComputerFactory {
    @Override
    public Mouse getMouse() {
        return new AppleMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new AppleKeyboard();
    }
}