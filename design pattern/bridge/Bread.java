public abstract class Bread {
    protected Jam jam = null;

    public Bread(Jam jam) {
        this.jam = jam;
    }
    public abstract String getBread();
    public String getFullName(){
        return jam.getJam()+getBread();
    }
}
