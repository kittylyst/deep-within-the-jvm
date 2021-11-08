package kathik.session3;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MHExamples {
    public static void main(String[] args) {
        var mh = new MHExamples();
        mh.run2();
    }

    private void run2() {
        Object obj = null, arg0 = null, arg1 = null;
        MethodHandle mh = getTwoArgMH();
        MyType ret;

        try {
            ret = (MyType)mh.invokeExact(obj, arg0, arg1);
            System.out.println(ret);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private MethodHandle getTwoArgMH() {
        return null;
    }

    void run() {
        var mt = MethodType.methodType(String.class);
    }


    private static class MyType {
    }
}
