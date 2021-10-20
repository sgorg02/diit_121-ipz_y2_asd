package com.company;

import java.util.Random;
import java.util.Arrays;

public class ArraySort {

    private int[] array;
    private int size;
    private final Random RANDOM = new Random();

    public ArraySort(int size) {
        this.size = size;
        array = new int[this.size];
    }

    /**
     * filling array by random
     *
     * @param min min value of range
     * @param max max value of range
     */
    public void randFilling(int min, int max) {
        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(max - min) + min;
        }

    }

    //cmp jmp mov
    public int bubbleSort() {
        int total = 0;
        total++;//=
        for (int i = 0; i < size - 1; i++) {
            total++;//<
            total++;//=
            for (int j = 0; j < size - 1 - i; j++) {
                total++;//<
                total++;//if
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    total += 3;
                }
                total++;//++
                total++;//jmp
            }
            total++;//<

            total++;//++
            total++;//jmp
        }
        total++;//<
        return total;
    }

    public int quickSort(int total_tmp,int low, int high){
        //int total = 0;
        total_tmp++;//=
        if(array.length == 0)
            return total_tmp;

        total_tmp++;
        if(low >= high)
            return total_tmp;

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        total_tmp++;
        int opora = array[middle];
        total_tmp++;

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        total_tmp += 2;
        while (i <= j) {
            total_tmp++;
            while (array[i] < opora) {
                total_tmp++;
                i++;
                total_tmp++;
            }

            total_tmp++;
            while (array[j] > opora) {
                total_tmp++;
                j--;
                total_tmp++;
            }
            total_tmp++;

            total_tmp++;
            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
                total_tmp += 5;
            }
        }
        total_tmp++;


        // вызов рекурсии для сортировки левой и правой части
        total_tmp++;
        if (low < j) {
            total_tmp++;
            total_tmp = quickSort(total_tmp, low, j);
        }

        total_tmp++;
        if (high > i) {
            total_tmp++;
            total_tmp = quickSort(total_tmp, i, high);
        }

        return total_tmp;
    }

    public int selectionSort(){
        int total = 1;
        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            total += 2;
            int pos = i;
            total++;
            int min = array[i];
            total += 2;
            for (int j = i + 1; j < array.length; j++) {// цикл выбора наименьшего элемента
                total += 2;
                if (array[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                    total += 2;
                }
                total += 2;
            }
            array[pos] = array[i];
            array[i] = min;    // меняем местами наименьший с array[i]
            total += 5;
        }
        total++;

        return  total;
    }
}