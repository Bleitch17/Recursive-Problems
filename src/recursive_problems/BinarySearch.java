package recursive_problems;

public class BinarySearch {
    /**
     * A function which implements a recursive binary search algorithm over a specified portion of an integer array.
     * @param arr An array of integers to search. {@param arr} is sorted in non-decreasing order.
     * @param lo The low bound of the search range; the lowest index in the array to search.
     *           0 <= {@param lo} <= {@param hi}
     * @param hi The upper bound of the search range; the highest index in the array to search.
     *           {@param hi} < {@param arr}.length
     * @param key The value to search the array for.
     * @return If {@param key} is in the array: An index i such that {@param lo} <= i {@param hi}, and
     * {@param arr}[i] == key. If {@param key} is not in the array, returns -1.
     */
    public static int binarySearch(int[] arr, int lo, int hi, int key) {
        // Calculate the midpoint:
        int mid = (hi+lo) >> 1;

        // Base case 1: arr[mid] == key
        if (arr[mid] == key)
            return mid;

        // Base case 2: There is one element in the array, and the first check failed. Key is not in array.
        if (lo == hi)
            return -1;

        // Since arr[mid] != key, either key > arr[mid], key < arr[mid], or key not in arr.
        if (key < arr[mid]) {
            return binarySearch(arr, lo, mid - 1, key);
        } else if (key > arr[mid]) {
            return binarySearch(arr, mid + 1, hi, key);
        }
        return -1;
    }
}
