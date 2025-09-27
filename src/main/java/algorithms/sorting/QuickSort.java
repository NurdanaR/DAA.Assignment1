package algorithms.sorting;

import algorithms.util.Metrics;
import algorithms.util.ArrayUtils;

import java.util.Random;

public class QuickSort {
    private static final Random random = new Random();

    public static void sort(int[] arr, Metrics m) {
        m.start();
        quickSort(arr, 0, arr.length - 1, m);
        m.stop();
    }

    private static void quickSort(int[] arr, int left, int right, Metrics m) {
        while (left < right) {
            m.enterRecursion();
            int pivotIndex = left + random.nextInt(right - left + 1);
            int pivot = arr[pivotIndex];
            ArrayUtils.swap(arr, pivotIndex, right);
            int p = partition(arr, left, right, pivot, m);
            if (p - left < right - p) {
                quickSort(arr, left, p - 1, m);
                left = p + 1;
            } else {
                quickSort(arr, p + 1, right, m);
                right = p - 1;
            }
            m.exitRecursion();
        }
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics m) {
        int i = left;
        for (int j = left; j < right; j++) {
            m.incComparisons();
            if (arr[j] <= pivot) {
                ArrayUtils.swap(arr, i, j);
                i++;
            }
        }
        ArrayUtils.swap(arr, i, right);
        return i;
    }
}