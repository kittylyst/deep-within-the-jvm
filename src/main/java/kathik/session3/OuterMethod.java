package kathik.session3;

public class OuterMethod {
    private int i = 0;

    private int getI() {
        return i;
    }

    public class Inner {
        public int getI() {
            return getI();
        }
    }
}