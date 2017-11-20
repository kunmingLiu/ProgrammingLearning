public class JuiceFactory {
    public final static int APPLE_JUICE = 0;
    public final static int ORANGE_JUICE = 1;
    public static Juice getJuice(int type){
        switch (type){
            case APPLE_JUICE:
                return new AppleJuice();
            case ORANGE_JUICE:
                return new OrangeJuice();
            default:
                throw new IllegalArgumentException("沒有這種果汁");
        }
    }
}
