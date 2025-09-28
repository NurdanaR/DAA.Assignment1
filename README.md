# DAA Assignment 1: Divide-and-Conquer Algorithms

## 1. Project Overview
This project implements classical divide-and-conquer algorithms in Java 17 using safe recursion patterns. Metrics for performance, recursion depth, and comparisons are collected and analyzed.

### Algorithms Implemented
1. MergeSort – linear merge, reusable buffer, small-n cutoff (Insertion Sort).
2. QuickSort – randomized pivot, smaller-first recursion.
3. Deterministic Select – median-of-medians (MoM5), O(n) selection.
4. Closest Pair of Points (2D) – divide-and-conquer, O(n log n).

## 2. Architecture Notes
. Recursion depth is controlled using smaller-first recursion (QuickSort, Select).  
. MergeSort uses a reusable buffer to reduce allocations.  
. Partition, swap, and utility methods are refactored for reuse.  

## 3. Recurrence Analysis
### MergeSort
. Recurrence: T(n) = 2T(n/2) + Θ(n)  
. Master Theorem Case 2: T(n) = Θ(n log n)  
. Verified by running the algorithm on arrays of different sizes; buffer reuse reduces constants.

### QuickSort
. Recurrence: T(n) = T(k) + T(n-k-1) + Θ(n)  
. Randomized pivot ensures average recursion depth ≈ O(log n)  
. Verified by running Main.java on example arrays; recursion depth bounded as expected.

### Deterministic Select
. Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n)  
. Complexity: O(n)  
. Verified correctness by comparing results with Arrays.sort()[k] on sample arrays.

### Closest Pair
. Recurrence: T(n) = 2T(n/2) + Θ(n) (plus strip check)  
. Complexity: O(n log n)  
. Verified by comparing results with brute-force method on small n (≤2000).

## 4. Metrics
. Time vs n: runtime grows log-linearly for MergeSort and QuickSort.  
. Recursion depth vs n: QuickSort depth bounded ≈ 2*floor(log2 n).  
. Discussion: buffer reuse and cache effects influence constants.


## 5. GitHub Workflow
. Branches: main, feature/mergesort, feature/quicksort, feature/select, feature/closest, feature/metrics  
. Commits examples:
  - init: maven, README.md
  - feat(metrics): counters, depth tracker
  - feat(mergesort): baseline + buffer + cutoff
  - feat(quicksort): smaller-first recursion + randomized pivot
  - feat(select): deterministic select (MoM5)
  - feat(closest): divide-and-conquer implementation
  - docs(report): initial README & metrics
  - release: v1.0


## 6. Testing
- Algorithm correctness verified manually via Main.java execution.  
- MergeSort, QuickSort, Select, and Closest Pair run on example arrays to confirm correct output.  


## 7. Submission
- GitHub repository: https://github.com/NurdanaR/DAA.Assignment1.  
- README.md contains full report and description of all algorithms.

## Nurdana Moldabay
## SE-2406
