public class Bagel extends Bread {
    public Bagel(Jam jam) {
        super(jam);
    }

    @Override
    public String getBread() {
        return "貝果";
    }
}
