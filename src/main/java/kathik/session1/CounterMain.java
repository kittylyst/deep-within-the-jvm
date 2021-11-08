package kathik.session1;

/**
 * @author ben
 */
public class CounterMain {

    public static final int REPS = 10_000_000;

    public static void main(String[] args) {
        long sleepStart = System.currentTimeMillis();
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            // Abnormal finish (i.e. interrupt)
            System.out.println(System.currentTimeMillis() - sleepStart);
            e.printStackTrace();
        }
        // Normal finish

        final Counter c = new UnprotectedCounter();

        Runnable r = () -> {
            for (int i = 0; i < REPS; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        int diff = 2 * REPS - c.get();
        System.out.println("Diff: " + diff);
        System.out.println("Elapsed: " + (fin - start));
    }

}
