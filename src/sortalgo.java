public class SortingAlgorithms {
    
    // Bubble Sort - O(n^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    // Merge Sort - O(n log n)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
            
        // Merge temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // Insertion Sort - O(n^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    // Quick Sort - O(n log n) average
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    //function for quick sort whats called a pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    // Radix Sort - O(nk) where k is the number of digits
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        
        // Do counting sort for every digit
        for (int exp = 1; max/exp > 0; exp *= 10)
            countSort(arr, exp);
    }
    //function for redix sort
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    //function for redix sort
    private static void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        
        // Store count of occurrences in count[]
        for (int i = 0; i < arr.length; i++)
            count[(arr[i]/exp)%10]++;
            
        // Change count[i] so that count[i] contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
            
        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10] - 1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        
        // Copy the output array to arr[]
        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
    
    // Shell Sort - O(n^1.5)
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                
                arr[j] = temp;
            }
        }
    }
    
    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Test arrays
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        int[] arr4 = arr1.clone();
        int[] arr5 = arr1.clone();
        int[] arr6 = arr1.clone();
        
        System.out.println("Original Array:");
        printArray(arr1);
        
        // Test all sorting algorithms
        System.out.println("\nBubble Sort:");
        bubbleSort(arr1);
        printArray(arr1);
        
        System.out.println("\nMerge Sort:");
        mergeSort(arr2, 0, arr2.length-1);
        printArray(arr2);
        
        System.out.println("\nInsertion Sort:");
        insertionSort(arr3);
        printArray(arr3);
        
        System.out.println("\nQuick Sort:");
        quickSort(arr4, 0, arr4.length-1);
        printArray(arr4);
        
        System.out.println("\nRadix Sort:");
        radixSort(arr5);
        printArray(arr5);
        
        System.out.println("\nShell Sort:");
        shellSort(arr6);
        printArray(arr6);
    }
}