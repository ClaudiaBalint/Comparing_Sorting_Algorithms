package com.example.proiect;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    private int comparisons;
    private long sortingTime;
    private List<List<Object>> comparisonSteps;

    public int[] sort(int[] array) {
        comparisons = 0;
        comparisonSteps = new ArrayList<>();
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        sortingTime = System.nanoTime() - startTime;
        return array;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public int getComparisons() {
        return comparisons;
    }

    public long getSortingTime() {
        return sortingTime;
    }
    public List<List<Object>> getComparisonSteps() {
        return comparisonSteps;
    }
}