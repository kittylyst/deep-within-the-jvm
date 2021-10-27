package kathik.session1;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * This classloader is constructed by passing a String of extra filesystem locations
 * to look for classes - it has an "extra classpath" that can be added at runtime
 */
public final class ExtraClassLoader extends ClassLoader {
    private final List<Path> extraDirs;

    /**
     * Constructs a classloader with the given extraPath
     * @param extraPath - a list of path names separated with :
     */
    public ExtraClassLoader(String extraPath) {
        super(ExtraClassLoader.class.getClassLoader());
        var dirs = extraPath.split(":");
        extraDirs = Arrays.stream(dirs).map(s -> Path.of(s)).toList();
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = super.findClass(name);
        } catch (ClassNotFoundException __) {
            // We actually need to load this ourselves, so find the path
            // corresponding to the directory where the classfile lives.
            var internalName = qualifiedClassNameToInternalForm(name);
            try {
                var clazzBytes = Files.readAllBytes(locateClassfile(internalName));
                cls = defineClass(null, clazzBytes, 0, clazzBytes.length);
//                try {
//                    cls = MethodHandles.lookup().defineClass(clazzBytes);
//                } catch (IllegalAccessException iax) {
//                    throw new ClassNotFoundException("Illegal Access", iax);
//                }
            } catch (IOException iox) {
                throw new ClassNotFoundException("IO Exception", iox);
            }
        }

        return cls;
    }

    /**
     * Helper method that converts from a fully-qualified class name to the internal class
     * name format (as used in the Constant Pool). No obvious library method to do this
     * appears to exist, hence this code.
     *
     * @param qualifiedClassName
     * @return
     */
    static String qualifiedClassNameToInternalForm(final String qualifiedClassName) {
        String out = qualifiedClassName.replaceAll("\\.", "/");
        return out;
    }

    /**
     * Helper method that takes a class name (in internal format) and returns a Path
     * corresponding to the dir where the classfile was found. This method also performs a
     * couple of basic sanity check on the
     * class file (e.g. that it exists, is a regular file and is readable).
     *
     * @param internalClassName
     * @return a path object that corresponds to a class that has been found
     * @throws ClassNotFoundException
     */
    private Path locateClassfile(final String internalClassName) throws ClassNotFoundException {
        for (final Path p : extraDirs) {
            final Path check = p.resolve(internalClassName + ".class");
            if (Files.isRegularFile(check)) {
                if (!Files.isReadable(check)) {
                    throw new ClassNotFoundException("File " + check + " found but is not readable");
                }
                return p;
            }
        }

        throw new ClassNotFoundException("Requested class " + internalClassName + " could not be found");
    }
}
