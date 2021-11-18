package kathik.session4.pets;

public class PetsMain {
    public static void main(String[] args) {
        var m = new PetsMain();
        m.run();
    }

    private void run() {
        var jesús = new Veterinarian("Jesús");
        var sara = new Veterinarian("Sara");
        Cat mariano = new Cat("Marianito");
        jesús.careFor(mariano);

        System.out.println(mariano.name());
        System.out.println(Veterinarian.isOpenToday());
    }
}
