package kathik.session3;

public class Structural {
        public static void main(String[] args) {
            (new Object() {
                public void bar() {
                    System.out.println("bar!");
                }
            }).bar();
        }
}