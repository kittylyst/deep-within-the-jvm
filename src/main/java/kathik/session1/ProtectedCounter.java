package kathik.session1;

/**
 *
 * @author ben
 */
public final class ProtectedCounter implements Counter {
    private int i = 0;

    public int increment() {
        synchronized (this) {
            return i = i + 1;
        }
    }

    public synchronized int get() {
        return i;
    }
}
