package kathik.session5.fx;

import kathik.session5.fx.sealed.FXFill;
import kathik.session5.fx.sealed.FXAccepted;
import kathik.session5.fx.sealed.FXOrderResponse;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class OrderResponseManager implements Runnable {
    private final BlockingQueue<FXOrderResponse> responses;
    private volatile boolean shutdown = false;

    public OrderResponseManager(BlockingQueue<FXOrderResponse> responses) {
        this.responses = responses;
    }

    @Override
    public void run() {
        LOOP: while (!shutdown) {
            try {
                FXOrderResponse toHandle = responses.poll(5, TimeUnit.SECONDS);
//                boolean success = false;
//                if (toHandle instanceof FXFill fill) {
//                    success = handleFill(fill);
//                } else if (toHandle instanceof FXAccepted accept) {
//                    success = true;
//                } else {
//                    success = false;
//                    System.out.println("Could not handle...");
//                }
                boolean success = switch(toHandle) {
                    case FXFill fill -> handleFill(fill);
                    case FXAccepted accept -> true;
                    default -> false;
                };
                System.out.println("Handled: "+ success);

            } catch (InterruptedException e) {
                shutdown = true;
                continue LOOP;
            }
        }
    }

    private boolean handleFill(FXFill toHandle) {
        // proceessing....
        return true;
    }

    public void shutdown() {
        shutdown = true;
    }
}
