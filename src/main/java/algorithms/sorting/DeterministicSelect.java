package algorithms.sorting;

import algorithms.util.Metrics;
import algorithms.util.ArrayUtils;

import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] arr, int k, Metrics m) {
        m.start();
        int result = select(arr, 0, arr.length - 1, k, m);
        m.stop();
        return result;
    }

    private static int select(int[] arr, int left, int right, int k, Metrics m) {
        while (true) {
            if (left == right) return arr[left];
            int pivotIndex = pivot(arr, left, right, m);
            int pivotPos = partition(arr, left, right, arr[pivotIndex], m);
            if (k == pivotPos) return arr[k];
            else if (k < pivotPos) right = pivotPos - 1;
            else left = pivotPos + 1;
        }
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics m) {
        int i = left;
        for (int j = left; j <= right; j++) {
            m.incComparisons();
            if (arr[j] < pivot) {
                ArrayUtils.swap(arr, i, j);
                i++;
            }
        }
        return i - 1;
    }

    private static int pivot(int[] arr, int left, int right, Metrics m) {
        if (right - left < 5) {
            Arrays.sort(arr, left, right + 1);
            return (left + right) >>> 1;
        }
        int numMedians = 0;
        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            Arrays.sort(arr, i, subRight + 1);
            int median = i + (subRight - i) / 2;
            ArrayUtils.swap(arr, left + numMedians, median);
            numMedians++;
        }
        return pivot(arr, left, left + numMedians - 1, m);
    }
}