public class AppleJuiceFactory extends JuiceFactory {
    @Override
    public Juice getJuice() {
        return new AppleJuice();
    }
}