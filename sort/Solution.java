package com.neway.sort;


public class Solution {

    public static void main(String arg[]) {
        Solution s = new Solution();
        int arr [] = {11,-1,99,56,-89,56,78,110,8,9,55,-7,69,-55,203,981};

        s.quickSort(arr, 0, arr.length - 1);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void quickSort(int arr[],int start,int end){
        if(start >= end) {
            return;
        }

        int pivot = getPivot(arr,start,end);
        int i = start;
        int j = end - 2;

        while(i < j) {
            while(arr[i] < pivot) {
                i++;
            }

            while(arr[j] > pivot) {
                j--;
            }

            if(i >= j) {
                swap(arr,i,end - 1);
                break;
            } else {
                swap(arr,i,j);
            }
        }
        quickSort(arr,start,i - 1);
        quickSort(arr,i + 1,end);
    }


    public int getPivot(int arr[],int start, int end) {
        int mid = (start + end) >> 1;
        if(arr[mid] < arr[start]) {
            swap(arr,mid,start);
        }

        if(arr[end] < arr[mid]) {
            swap(arr,mid,end);
        }

        if(arr[end] < arr[start]) {
            swap(arr,start,end);
        }

        swap(arr,mid,end - 1);
        return arr[end - 1];
    }

    private static void swap(int[] arr, int m, int n) {
        int i = arr[m];
        arr[m] = arr[n];
        arr[n] = i;
    }
}