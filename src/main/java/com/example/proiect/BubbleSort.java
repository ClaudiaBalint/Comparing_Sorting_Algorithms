package com.example.proiect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    private int comparisons;
    private long sortingTime;
    private List<List<Object>> comparisonSteps;

    public int[] sort(int[] array) {
        comparisons = 0;
        comparisonSteps = new ArrayList<>();
        long startTime = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                boolean swapped = false;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }

                List<Object> step = new ArrayList<>();
                if(swapped){
                    step.add(array[j + 1]);
                    step.add(array[j]);
                }
                else {
                    step.add(array[j]);
                    step.add(array[j + 1]);
                }
                step.add(swapped);
                step.add(Arrays.copyOf(array, array.length));
                comparisonSteps.add(step);
            }
        }
        sortingTime = System.nanoTime() - startTime;
        return array;
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

