package com.neway.sort;

import com.neway.util.ArrayUtil;

/**
 * Created by Neway on 2015/12/20.
 */
public class HeapSort implements Sort {

    public static void main(String args[]) {
        Sort sort = new HeapSort();
        int arr[] = {89, 78, 8, 5, 13, 12, 11, 1, 0};
        sort.sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(int[] arr) {

        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            createMaxHeap(arr,i,arr.length - 1);
        }

        for (int i = arr.length - 1; i >= 1; i--) {
            ArrayUtil.swap(arr,0,i);
            createMaxHeap(arr,0,i - 1);
        }

    }

    public void createMaxHeap(int arr[], int start, int endIndex) {
        int i = start;
        int j = start * 2 + 1;
        int temp = arr[start];
        while (j <= endIndex) {
            if (j + 1 <= endIndex && arr[j + 1] > arr[j])
                j++;

            if (arr[j] <= temp)
                break;

            arr[i] = arr[j];
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = temp;
    }
}
