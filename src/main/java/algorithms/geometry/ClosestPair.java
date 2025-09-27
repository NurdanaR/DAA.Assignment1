package algorithms.geometry;

import algorithms.util.Metrics;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    public static record Point(double x, double y) {}

    public static double closest(Point[] points, Metrics m) {
        m.start();
        Point[] sorted = Arrays.copyOf(points, points.length);
        Arrays.sort(sorted, Comparator.comparingDouble(p -> p.x));
        double result = closest(sorted, 0, sorted.length - 1, m);
        m.stop();
        return result;
    }

    private static double closest(Point[] pts, int left, int right, Metrics m) {
        if (right - left <= 3) {
            double min = Double.POSITIVE_INFINITY;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    m.incComparisons();
                    min = Math.min(min, dist(pts[i], pts[j]));
                }
            }
            return min;
        }
        int mid = (left + right) >>> 1;
        double d1 = closest(pts, left, mid, m);
        double d2 = closest(pts, mid + 1, right, m);
        double d = Math.min(d1, d2);

        Point[] strip = new Point[right - left + 1];
        int cnt = 0;
        double midX = pts[mid].x;
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].x - midX) < d) strip[cnt++] = pts[i];
        }
        Arrays.sort(strip, 0, cnt, Comparator.comparingDouble(p -> p.y));
        for (int i = 0; i < cnt; i++) {
            for (int j = i + 1; j < cnt && (strip[j].y - strip[i].y) < d; j++) {
                m.incComparisons();
                d = Math.min(d, dist(strip[i], strip[j]));
            }
        }
        return d;
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}