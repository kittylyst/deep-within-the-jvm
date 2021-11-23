package kathik.session5.loom;

import java.util.ArrayList;

//
// Do not actually run this code... it may crash your VM or laptop
//
public class CrashTheVM {
    private static void looper(int count) {
        var tid = Thread.currentThread().getId();
        if (count > 500) {
            return;
        }
        try {
            Thread.sleep(10);
            if (count % 100 == 0) {
                System.out.println("Thread id: "+ tid +" : "+ count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        looper(count + 1);
    }

    public static Thread makeThread(Runnable r) {
        return new Thread(r);
    }

    // Loom-specific code?
//    public static Thread makeThread(Runnable r) {
//        return Thread.builder().virtual().task(r).build();
//    }

    public static void main(String[] args) {
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 20_000; i = i + 1) {
            var t = makeThread(() -> looper(1));
            t.start();
            threads.add(t);
            if (i % 1_000 == 0) {
                System.out.println(i + " thread started");
            }
        }
        // Join all the threads
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
