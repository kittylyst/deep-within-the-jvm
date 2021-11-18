package kathik.session4;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReflectionExample {

    public static void main(String[] args) {
        var klazzFilename = args[0];
        Class<?> klazz = getKlazz(klazzFilename);
        Object o = null;
        try {
            o = klazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        for (var m : klazz.getDeclaredMethods()) {
//            System.out.println(m);
            for (var a : m.getDeclaredAnnotations()) {
                if (a.annotationType() == Test.class) {
//                    System.out.println(klazz +"."+ m.getName() +": "+ a);
                    try {
                        m.invoke(o);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
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
