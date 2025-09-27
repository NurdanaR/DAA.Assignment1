package algorithms;

import algorithms.sorting.MergeSort;
import algorithms.sorting.QuickSort;
import algorithms.sorting.DeterministicSelect;
import algorithms.geometry.ClosestPair;
import algorithms.geometry.ClosestPair.Point;
import algorithms.util.Metrics;
import algorithms.util.CSVWriter;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        Random random = new Random();
        int[] data = random.ints(n, 0, 1_000_000).toArray();

        Metrics metrics = new Metrics();

        int[] arr1 = Arrays.copyOf(data, data.length);
        metrics.reset(); MergeSort.sort(arr1, metrics);
        CSVWriter.append("results.csv", "MergeSort", n, metrics);

        int[] arr2 = Arrays.copyOf(data, data.length);
        metrics.reset(); QuickSort.sort(arr2, metrics);
        CSVWriter.append("results.csv", "QuickSort", n, metrics);

        int[] arr3 = Arrays.copyOf(data, data.length);
        metrics.reset(); int median = DeterministicSelect.select(arr3, arr3.length / 2, metrics);
        CSVWriter.append("results.csv", "DeterministicSelect", n, metrics);

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) points[i] = new Point(random.nextDouble(), random.nextDouble());
        metrics.reset(); double dist = ClosestPair.closest(points, metrics);
        CSVWriter.append("results.csv", "ClosestPair", n, metrics);
    }
}