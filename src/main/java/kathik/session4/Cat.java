package kathik.session4;

public class Cat extends Pet implements Furry {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void groom() {
        System.out.println("The cat "+ name() +" grooms themself");
    }
}
