package kathik.counters;

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

        Thread tA = new Thread(r);
        Thread tB = new Thread(r);
        long start = System.currentTimeMillis();
        tA.start();
        tB.start();
        try {
            tA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            tB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        int diff = 2 * REPS - c.get();
        System.out.println("Lost: " + diff);
        System.out.println("Elapsed: " + (fin - start));
    }

}
