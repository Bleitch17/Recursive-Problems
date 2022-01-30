package recursive_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Test 1:
        int[] arr = new int[] {2, 4, 5, 6, 9, 13, 17};
        int lo = 0;
        int hi = 6;
        int key = 5;
        int index = BinarySearch.binarySearch(arr, lo, hi, key);
        System.out.println("Index is: " + index);

        // Test 2:
        int[] arr2 = new int[] {998, 999};
        int lo2 = 0;
        int hi2 = 1;
        int key2 = 999;
        int index2 = BinarySearch.binarySearch(arr2, lo2, hi2, key2);
        System.out.println("Index2 is: " + index2);

        // Test 3:
        int[] arr3 = new int[] {1, 4, 9, 16, 25, 36};
        int lo3 = 0;
        int hi3 = 5;
        int key3 = 1;
        int index3 = BinarySearch.binarySearch(arr3, lo3, hi3, key3);
        System.out.println("Index2 is: " + index3);
    }

}

