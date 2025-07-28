package com.example.proiect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    private int comparisons;
    private long sortingTime;
    private List<List<Object>> comparisonSteps;

    public int[] sort(int[] array) {
        comparisons = 0;
        comparisonSteps = new ArrayList<>();
        long startTime = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                boolean swapped = false;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                addStep(array[minIndex], array[j], swapped, Arrays.copyOf(array, array.length));
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                addStep(array[i], array[minIndex], true, Arrays.copyOf(array, array.length));
            }
        }
        sortingTime = System.nanoTime() - startTime;
        return array;
    }

    private void addStep(int compared1, int compared2, boolean swapped, int[] currentArray) {
        List<Object> step = new ArrayList<>();
        step.add(compared1);
        step.add(compared2);
        step.add(swapped);
        step.add(currentArray);
        comparisonSteps.add(step);
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
