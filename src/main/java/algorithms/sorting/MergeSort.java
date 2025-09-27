package algorithms.sorting;

import algorithms.util.Metrics;

public class MergeSort {
    private static final int CUTOFF = 16;

    public static void sort(int[] arr, Metrics m) {
        int[] buffer = new int[arr.length];
        m.start();
        sort(arr, buffer, 0, arr.length - 1, m);
        m.stop();
    }

    private static void sort(int[] arr, int[] buffer, int left, int right, Metrics m) {
        m.enterRecursion();
        if (right - left <= CUTOFF) {
            insertionSort(arr, left, right, m);
            m.exitRecursion();
            return;
        }
        int mid = (left + right) >>> 1;
        sort(arr, buffer, left, mid, m);
        sort(arr, buffer, mid + 1, right, m);
        merge(arr, buffer, left, mid, right, m);
        m.exitRecursion();
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right, Metrics m) {
        for (int i = left; i <= right; i++) {
            buffer[i] = arr[i];
            m.incAllocations();
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) arr[k] = buffer[j++];
            else if (j > right) arr[k] = buffer[i++];
            else {
                m.incComparisons();
                if (buffer[j] < buffer[i]) arr[k] = buffer[j++];
                else arr[k] = buffer[i++];
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right, Metrics m) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left) {
                m.incComparisons();
                if (arr[j] <= key) break;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}