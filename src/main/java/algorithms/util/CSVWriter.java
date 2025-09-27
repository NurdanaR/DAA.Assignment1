package algorithms.util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void append(String fileName, String algo, int n, Metrics m) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(String.format(
                    "%s,%d,%d,%d,%d,%.6f\n",
                    algo,
                    n,
                    m.getComparisons(),
                    m.getRecursionDepth(),
                    m.getAllocations(),
                    m.getTimeSeconds()
            ));
        } catch (IOException e) {
            throw new RuntimeException("CSV write error", e);
        }
    }
}