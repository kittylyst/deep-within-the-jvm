package kathik.counters;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarhandleCounter implements Counter {
    private static final VarHandle vh;
    private volatile int value = 0;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            vh = l.findVarHandle(VarhandleCounter.class, "value", int.class);
        } catch (Exception ex) { throw new Error(ex); }
    }

    @Override
    public int increment() {
        var currBal = value;
//        vh.isAccessModeSupported();
        var newBal = currBal + 1;
        while (!vh.compareAndSet(this, currBal, newBal)) {
            currBal = value;
            newBal = currBal + 1;
        }
        return newBal;
    }


    @Override
    public int get() {
        return value;
    }
}
