package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        try (FileWriter writer = new FileWriter("bubbleSortResult.txt", true)) {
            final int MINSIZE = 10;
            final int MAXSIZE = 100;
            final int AMOUNT = 100;
            int total = 0;
            for (int i = MINSIZE; i <= MAXSIZE; i += 10) {
                ArraySort arrayBubbleSort = new ArraySort(i);
                for (int j = 0; j < AMOUNT; j++) {
                    arrayBubbleSort.randFilling(1, 100);
                    total = total + arrayBubbleSort.bubbleSort();
                }
                int avg = total / AMOUNT;
                System.out.println(i + ": " + avg);
                writer.write(avg + "\n");
                total = 0;

            }
        }

        try (FileWriter writer = new FileWriter("QuickSortResult.txt", true)) {
            final int MINSIZE = 10;
            final int MAXSIZE = 100;
            final int AMOUNT = 100;
            int total = 0;
            int total_tmp = 0;
            int low = 0;
            for (int i = MINSIZE; i <= MAXSIZE; i += 10) {
                int high = i - 1;
                ArraySort arrayQuickSort = new ArraySort(i);
                for (int j = 0; j < AMOUNT; j++) {
                    arrayQuickSort.randFilling(1, 100);
                    total = total + arrayQuickSort.quickSort(total_tmp, low, high);
                }
                int avg = total / AMOUNT;
                System.out.println(i + ": " + avg);
                writer.write(avg + "\n");
                total = 0;

            }
        }

        try (FileWriter writer = new FileWriter("SelectionSortResult.txt", true)) {
            final int MINSIZE = 10;
            final int MAXSIZE = 100;
            final int AMOUNT = 100;
            int total = 0;
            for (int i = MINSIZE; i <= MAXSIZE; i += 10) {
                ArraySort arraySelectionSort = new ArraySort(i);
                for (int j = 0; j < AMOUNT; j++) {
                    arraySelectionSort.randFilling(1, 100);
                    total = total + arraySelectionSort.selectionSort();
                }
                int avg = total / AMOUNT;
                System.out.println(i + ": " + avg);
                writer.write(avg + "\n");
                total = 0;

            }
        }

    }
}