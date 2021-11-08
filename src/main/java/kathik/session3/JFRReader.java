package kathik.session3;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Path;

public class JFRReader {

    public static void main(String[] args) {
        var jfrFile = Path.of(args[0]);
        try {
            for (var event : RecordingFile.readAllEvents(jfrFile)) {
                processEvent(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void processEvent(RecordedEvent event) {

    }
}
