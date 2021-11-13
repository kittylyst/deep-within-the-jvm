package kathik.session4.pets;

public class Dog extends Pet implements Furry {

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void groom() {
        System.out.println(name()+ " likes being groomed");
    }

    @Override
    public void feed() {
        System.out.println(name()+ " likes being fed");
    }

}
