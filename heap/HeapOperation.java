package com.neway.heap;

/**
 * Created by Neway on 2015/12/20.
 */
public class HeapOperation {

    public static void maxMinHeap(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            maxHeapFixdown(arr, i);
    }

    public static void maxHeapFixdown(int arr[], int i) {
        int j, temp;

        temp = arr[i];
        j = 2 * i + 1;
        while (j < arr.length) {
            if (j + 1 < arr.length && arr[j + 1] > arr[j]) //find the bigger one between the left subnode and right subnode
                j++;

            if (arr[j] <= temp)
                break;

            arr[i] = arr[j];     //replace the parent with the bigger one.
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = temp;
    }
}
