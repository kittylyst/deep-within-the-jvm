package kathik.session4;

public class LoopExample {

    public static void main(String[] args) {
        var total = 0;
        for (int i = 0; i < 128; i = i + 1) {
            total = total + 1;
            // Check safepoint
        }
        System.out.println(total);
    }

    public void foo() {
        Object o = bar();
//        Object o = new Object(); // inlined call to bar();
        System.out.println(o);
    }

    private Object bar() {
        return new Object();
    }

}
