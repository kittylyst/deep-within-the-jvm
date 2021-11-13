package kathik.session4;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReflectionExample {

    public static void main(String[] args) {
        var klassFilename = args[0];
        Class<?> klazz = getKlazz(klassFilename);

        for (var m : klazz.getDeclaredMethods()) {
//            System.out.println(m);
            for (var a : m.getDeclaredAnnotations()) {
                System.out.println(klazz +"."+ m.getName() +": "+ a);
            }
        }
    }

    @Deprecated
    public void foo() {

    }

    private static Class<?> getKlazz(String klassFilename) {
        var mycl = new MyCL();
        return mycl.makeClass(klassFilename);
//        try {
//            var clazzBytes = Files.readAllBytes(Path.of(klassFilename));
//            return MethodHandles.lookup().defineClass(clazzBytes);
//        } catch (IllegalAccessException | IOException ix) {
//            throw new RuntimeException("Failed to load", ix);
//        }
    }
}
