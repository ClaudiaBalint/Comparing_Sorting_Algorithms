package com.example.proiect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class SortareAnimata extends AppCompatActivity {
    private TextView textViewInitial;
    private TextView textViewAlg;
    private TextView textViewSteps;
    private TextView textViewFinal;
    private TextView textViewComparisons;
    private TextView textViewTime;
    private Button buttonShowSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortare_animata);

        textViewInitial = findViewById(R.id.textViewInitial);
        textViewAlg = findViewById(R.id.textViewAlg);
        textViewSteps = findViewById(R.id.textViewSteps);
        textViewFinal = findViewById(R.id.textViewFinal);
        textViewComparisons = findViewById(R.id.textViewComparisons);
        textViewTime = findViewById(R.id.textViewTime);
        buttonShowSteps = findViewById(R.id.buttonShowSteps);

        String algorithm = getIntent().getStringExtra("algoritm");
        String inputValues = getIntent().getStringExtra("valori");

        textViewAlg.setText(algorithm);
        textViewInitial.setText("\nLista inițială: " + inputValues);

        int[] sortedValues;
        long sortingTime;
        List<List<Object>> steps = null;

        switch (algorithm) {
            case "Quick Sort":
                QuickSort quickSort = new QuickSort();
                sortedValues = quickSort.sort(parseInputValues(inputValues));
                sortingTime = quickSort.getSortingTime();
                textViewComparisons.setText("\nNumărul de comparații: " + quickSort.getComparisons());
                break;
            case "Merge Sort":
                MergeSort mergeSort = new MergeSort();
                sortedValues = mergeSort.sort(parseInputValues(inputValues));
                sortingTime = mergeSort.getSortingTime();
                textViewComparisons.setText("\nNumărul de comparații: " + mergeSort.getComparisons());
                break;
            case "Insertion Sort":
                InsertionSort insertionSort = new InsertionSort();
                sortedValues = insertionSort.sort(parseInputValues(inputValues));
                sortingTime = insertionSort.getSortingTime();
                steps = insertionSort.getComparisonSteps();
                textViewComparisons.setText("\nNumărul de comparații: " + insertionSort.getComparisons());
                break;
            case "Selection Sort":
                SelectionSort selectionSort = new SelectionSort();
                sortedValues = selectionSort.sort(parseInputValues(inputValues));
                sortingTime = selectionSort.getSortingTime();
                steps = selectionSort.getComparisonSteps();
                textViewComparisons.setText("\nNumărul de comparații: " + selectionSort.getComparisons());
                break;
            case "Bubble Sort":
                BubbleSort bubbleSort = new BubbleSort();
                sortedValues = bubbleSort.sort(parseInputValues(inputValues));
                sortingTime = bubbleSort.getSortingTime();
                steps = bubbleSort.getComparisonSteps();
                textViewComparisons.setText("\nNumărul de comparații: " + bubbleSort.getComparisons());
                break;
            default:
                BubbleSort defaultSort = new BubbleSort();
                sortedValues = defaultSort.sort(parseInputValues(inputValues));
                sortingTime = defaultSort.getSortingTime();
                steps = defaultSort.getComparisonSteps();
                textViewComparisons.setText("\nNumărul de comparații: " + defaultSort.getComparisons());
                break;
        }

        textViewFinal.setText("\nLista sortată: " + Arrays.toString(sortedValues));
        textViewTime.setText("\nTimpul de sortare: " + sortingTime/ 1000000 + " ms");

        List<List<Object>> finalSteps = steps;
        buttonShowSteps.setOnClickListener(v -> {
            if (finalSteps != null) {
                if (textViewSteps.getVisibility() == View.VISIBLE) {
                    textViewSteps.setVisibility(View.GONE);
                } else {
                    displaySortSteps(finalSteps);
                    textViewSteps.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private int[] parseInputValues(String inputValues) {
        String[] values = inputValues.split(",");
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }
        return array;
    }

    private void displaySortSteps(List<List<Object>> steps) {
        StringBuilder stepsText = new StringBuilder();

        for (List<Object> step : steps) {
            int compared1 = (int) step.get(0);
            int compared2 = (int) step.get(1);
            boolean swapped = (boolean) step.get(2);
            int[] currentArray = (int[]) step.get(3);

            String text = "\nse compară: " + compared1 + " și " + compared2;
            if (swapped) {
                text += " (schimbat)";
            }
            text += "\nLista curentă: " + Arrays.toString(currentArray);
            stepsText.append(text).append("\n");
        }

        textViewSteps.setText(stepsText.toString());
    }

}
