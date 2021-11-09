package kathik.session1;

public class CLMain {
    public static void main(String[] args) {
        var cl = new MyCL();
        try {
            Class<?> clz = cl.loadClass(args[0]);
            System.out.println(clz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
