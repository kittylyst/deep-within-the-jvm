package kathik.session4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyCL extends ClassLoader {

    public Class<?> makeClass(String name) {
        Class<?> cls;
        try {
            var clazzBytes = Files.readAllBytes(Path.of(name));
            cls = defineClass(null, clazzBytes, 0, clazzBytes.length);
        } catch (IOException iox) {
            throw new RuntimeException("Error", iox);
        }

        return cls;
    }

}
