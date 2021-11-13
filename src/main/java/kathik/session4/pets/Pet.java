package kathik.session4.pets;

public abstract class Pet extends java.lang.Object {
    private final String name;
    private int age;

    public Pet(String name) {
        this.name = name;
        this.age = 0;
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public void birthday() {
        age = age + 1;
    }

    public void feed() {
        System.out.println("Shh! "+ name + " is eating");
    }

}
