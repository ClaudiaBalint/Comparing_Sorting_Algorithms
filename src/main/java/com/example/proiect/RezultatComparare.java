package com.example.proiect;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class RezultatComparare extends AppCompatActivity {

    private TextView textViewInitial;
    private TextView textViewFinal1;
    private TextView textViewAlg1;
    private TextView textViewAlg2;
    private TextView textViewComparisons1;
    private TextView textViewComparisons2;
    private TextView textViewTime1;
    private TextView textViewTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat_comparare);

        textViewInitial = findViewById(R.id.textViewInitial2);
        textViewFinal1 = findViewById(R.id.textViewFinal1);
        textViewAlg1 = findViewById(R.id.textViewAlg1);
        textViewAlg2 = findViewById(R.id.textViewAlg2);
        textViewComparisons1 = findViewById(R.id.textViewComparisons1);
        textViewComparisons2 = findViewById(R.id.textViewComparisons2);
        textViewTime1 = findViewById(R.id.textViewTime1);
        textViewTime2 = findViewById(R.id.textViewTime2);

        String inputValues = getIntent().getStringExtra("valori");
        String algorithm1 = getIntent().getStringExtra("algoritm1");
        String algorithm2 = getIntent().getStringExtra("algoritm2");

        textViewInitial.setText("\nLista inițială: \n" + inputValues);

        int[] sortedValues1;
        long sortingTime1;

        switch (algorithm1) {
            case "Quick Sort":
                QuickSort quickSort = new QuickSort();
                sortedValues1 = quickSort.sort(parseInputValues(inputValues));
                sortingTime1 = quickSort.getSortingTime();
                textViewAlg1.setText("Pentru algoritmul QuickSort");
                textViewComparisons1.setText("\nNumărul de comparații: " + quickSort.getComparisons());
                break;
            case "Merge Sort":
                MergeSort mergeSort = new MergeSort();
                sortedValues1 = mergeSort.sort(parseInputValues(inputValues));
                sortingTime1 = mergeSort.getSortingTime();
                textViewAlg1.setText("Pentru algoritmul MergeSort");
                textViewComparisons1.setText("\nNumărul de comparații: " + mergeSort.getComparisons());
                break;
            case "Insertion Sort":
                InsertionSort insertionSort = new InsertionSort();
                sortedValues1 = insertionSort.sort(parseInputValues(inputValues));
                sortingTime1 = insertionSort.getSortingTime();
                textViewAlg1.setText("Pentru algoritmul InsertionSort");
                textViewComparisons1.setText("\nNumărul de comparații: " + insertionSort.getComparisons());
                break;
            case "Selection Sort":
                SelectionSort selectionSort = new SelectionSort();
                sortedValues1 = selectionSort.sort(parseInputValues(inputValues));
                sortingTime1 = selectionSort.getSortingTime();
                textViewAlg1.setText("Pentru algoritmul SelectionSort");
                textViewComparisons1.setText("\nNumărul de comparații: " + selectionSort.getComparisons());
                break;
            case "Bubble Sort":
                BubbleSort bubbleSort = new BubbleSort();
                sortedValues1 = bubbleSort.sort(parseInputValues(inputValues));
                sortingTime1 = bubbleSort.getSortingTime();
                textViewAlg1.setText("Pentru algoritmul BubbleSort");
                textViewComparisons1.setText("\nNumărul de comparații: " + bubbleSort.getComparisons());
                break;
            default:
                BubbleSort defaultSort = new BubbleSort();
                sortedValues1 = defaultSort.sort(parseInputValues(inputValues));
                sortingTime1 = defaultSort.getSortingTime();
                textViewAlg1.setText("Pentru algoritmul BubbleSort");
                textViewComparisons1.setText("\nNumărul de comparații: " + defaultSort.getComparisons());
                break;
        }

        textViewFinal1.setText("Lista sortată: \n" + Arrays.toString(sortedValues1));
        textViewTime1.setText("\nTimpul de sortare: " + sortingTime1/1000000 + " ms");

        int[] sortedValues2;
        long sortingTime2;

        switch (algorithm2) {
            case "Quick Sort":
                QuickSort quickSort = new QuickSort();
                sortedValues2 = quickSort.sort(parseInputValues(inputValues));
                sortingTime2 = quickSort.getSortingTime();
                textViewAlg2.setText("\nPentru algoritmul QuickSort");
                textViewComparisons2.setText("\nNumărul de comparații: " + quickSort.getComparisons());
                break;
            case "Merge Sort":
                MergeSort mergeSort = new MergeSort();
                sortedValues2 = mergeSort.sort(parseInputValues(inputValues));
                sortingTime2 = mergeSort.getSortingTime();
                textViewAlg2.setText("\nPentru algoritmul MergeSort");
                textViewComparisons2.setText("\nNumărul de comparații: " + mergeSort.getComparisons());
                break;
            case "Insertion Sort":
                InsertionSort insertionSort = new InsertionSort();
                sortedValues2 = insertionSort.sort(parseInputValues(inputValues));
                sortingTime2 = insertionSort.getSortingTime();
                textViewAlg2.setText("\nPentru algoritmul InsertionSort");
                textViewComparisons2.setText("\nNumărul de comparații: " + insertionSort.getComparisons());
                break;
            case "Selection Sort":
                SelectionSort selectionSort = new SelectionSort();
                sortedValues2 = selectionSort.sort(parseInputValues(inputValues));
                sortingTime2 = selectionSort.getSortingTime();
                textViewAlg2.setText("\nPentru algoritmul SelectionSort");
                textViewComparisons2.setText("\nNumărul de comparații: " + selectionSort.getComparisons());
                break;
            case "Bubble Sort":
                BubbleSort bubbleSort = new BubbleSort();
                sortedValues2 = bubbleSort.sort(parseInputValues(inputValues));
                sortingTime2 = bubbleSort.getSortingTime();
                textViewAlg2.setText("\nPentru algoritmul BubbleSort");
                textViewComparisons2.setText("\nNumărul de comparații: " + bubbleSort.getComparisons());
                break;
            default:
                // Algoritmul implicit de sortare
                BubbleSort defaultSort = new BubbleSort();
                sortedValues2 = defaultSort.sort(parseInputValues(inputValues));
                sortingTime2 = defaultSort.getSortingTime();
                textViewAlg2.setText("\nPentru algoritmul BubbleSort");
                textViewComparisons2.setText("\nNumărul de comparații: " + defaultSort.getComparisons());
                break;
        }

        textViewFinal1.setText("Lista sortată: \n" + Arrays.toString(sortedValues2));
        textViewTime2.setText("\nTimpul de sortare: " + sortingTime2/1000000 + " ms");
    }

    private int[] parseInputValues(String inputValues) {
        String[] values = inputValues.split(",");
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }
        return array;
    }
}
