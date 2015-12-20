package com.neway.util;

/**
 * Created by Neway on 2015/12/20.
 */
public class ArrayUtil {

    public static void swap(int arr[],int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
