package kathik.session4.pets;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    private void run() {
        Cat c = new Cat("Marianito");
        System.out.println(c.toString());
    }

}
