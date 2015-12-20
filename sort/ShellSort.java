package com.neway.sort;

/**
 * Created by Neway on 2015/12/6.
 */
public class ShellSort implements Sort {

    public static void main(String args[]) {
        int arr[] = {13,14,94,33,82,25,59,94,65,23,45,27,73,25,39,10};
        Sort sort = new ShellSort();
        sort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sort(int[] arr) {
        int step = 5;
        while (step > 0) {
            int x = (arr.length / step ) ;
            for (int i = 0; i < arr.length / x; i++) {
                int stepArray[] = new int[x];
                for (int m = 0; m < x; m++) {
                    stepArray[m] = arr[m * step + i];
                }
                insertSort(stepArray);
                for (int m = 0; m < x; m++) {
                    arr[m * step + i] = stepArray[m];
                }
            }
            step = step / 2;
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertPosition = -1;
            int cache = arr[i]; //缓存当前的值

            //从前面排好序的数字中间找到第一个大于当前数字的，它的位置就是当前数字应该在的位置。
            for (int m = 0; m < i; m++) {
                if (arr[i] < arr[m]) {
                    insertPosition = m;
                    break;
                }
            }

            //如果找到了了，就把数字依次往后移动一位。
            if (insertPosition != -1) {
                for (int j = i; j > insertPosition && insertPosition != -1; j--) {
                    arr[j] = arr[j - 1];
                }
                // 把当前数字放到腾出来的位置上去。
                arr[insertPosition] = cache;
            }

        }
    }
}
