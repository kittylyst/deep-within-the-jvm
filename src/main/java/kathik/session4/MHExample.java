package kathik.session4;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MHExample {

    public static void main(String[] args) {
        var main = new MHExample();
        main.run();
    }

    public void run() {
        var mh = getToStringMH();
        try {
            mh.invoke(this, 17);
//            System.out.println(s);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public MethodHandle getToStringMH() {
        MethodHandle mh = null;
        MethodType mt = MethodType.methodType(void.class, int.class);
        MethodHandles.Lookup lk = MethodHandles.lookup();

        try {
            mh = lk.findVirtual(getClass(), "foo", mt);
        } catch (NoSuchMethodException | IllegalAccessException mhx) {
            throw (AssertionError)new AssertionError().initCause(mhx);
        }

        return mh;
    }

    private void foo(int i) {
        System.out.println("Foo: "+ i);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MHExample{");
        sb.append('}');
        return sb.toString();
    }
}
