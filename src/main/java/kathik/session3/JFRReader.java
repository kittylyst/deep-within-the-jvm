package kathik.session3;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Path;

public final class JFRReader {

    public static void main(String[] args) {
        var jfr = new JFRReader();
        jfr.run(args[0]);
    }

    void run(final String fName) {
        var jfrFile = Path.of(fName);
        try {
            for (var event : RecordingFile.readAllEvents(jfrFile)) {
                processEvent(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void processEvent(final RecordedEvent event) {
        if (event.getEventType().getName().equals("jdk.ObjectAllocationInNewTLAB")) {
            var time = event.getStartTime().toEpochMilli();
            var alloc = event.getLong("tlabSize");
            System.out.println(time +","+ alloc);
        }
        // "jdk.GarbageCollection" "longestPause"

    }
}
