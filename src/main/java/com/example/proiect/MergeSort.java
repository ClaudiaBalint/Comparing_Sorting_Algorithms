package com.example.proiect;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private int comparisons;
    private long sortingTime;
    private List<List<Object>> comparisonSteps;

    public int[] sort(int[] array) {
        comparisons = 0;
        comparisonSteps = new ArrayList<>();
        long startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        sortingTime = System.nanoTime() - startTime;
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
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