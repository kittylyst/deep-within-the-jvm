package kathik.session4;

public class Pet extends java.lang.Object {
    private final String name;

    public Pet(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    private void sleep() {
        System.out.println("Shh! "+ name + " is sleeping");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
