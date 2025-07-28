package com.example.proiect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    private int comparisons;
    private long sortingTime;
    private List<List<Object>> comparisonSteps;

    public int[] sort(int[] array) {
        comparisons = 0;
        comparisonSteps = new ArrayList<>();
        long startTime = System.nanoTime();

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            boolean inserted = false;

            while (j >= 0 && array[j] > key) {
                comparisons++;
                array[j + 1] = array[j];
                addStep(array[j], key, true, Arrays.copyOf(array, array.length));
                j = j - 1;
                inserted = true;
            }
            array[j + 1] = key;
            if (!inserted) {
                comparisons++;
                addStep(array[j], key, false, Arrays.copyOf(array, array.length));
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
