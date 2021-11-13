package kathik.session4;

public class Cat extends Pet implements Furry {
    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void groom() {
        System.out.println("The cat "+ name() +" grooms themself");
    }

    @Override
    public void feed() {
        System.out.println("Silence food ape, "+ name() + " is eating");
    }

    public void purr() {
        System.out.println(name() + " purrs. Why would you disturb them?");
    }
}
