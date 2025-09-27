package algorithms.util;

public class Metrics {
    private long comparisons;
    private long allocations;
    private long recursionDepth;
    private long currentDepth;
    private long startTime;
    private long endTime;

    public void reset() {
        comparisons = 0;
        allocations = 0;
        recursionDepth = 0;
        currentDepth = 0;
        startTime = 0;
        endTime = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public void incComparisons() {
        comparisons++;
    }

    public void incAllocations() {
        allocations++;
    }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > recursionDepth) recursionDepth = currentDepth;
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getAllocations() {
        return allocations;
    }

    public long getRecursionDepth() {
        return recursionDepth;
    }

    public double getTimeSeconds() {
        return (endTime - startTime) / 1e9;
    }
}