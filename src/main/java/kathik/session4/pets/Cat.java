package kathik.session4.pets;

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

    public void purr() {
        System.out.println("Silence food ape, "+ name() + " is purring. Why would you disturb them?");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cat{");
        sb.append("name='").append(name()).append('\'');
        sb.append(", age=").append(age());
        sb.append('}');
        return sb.toString();
    }
}
