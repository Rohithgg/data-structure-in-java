public class searchalgo {
    
    // Binary Search (Iterative)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target)
                return mid;
                
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    
    // Uniform Binary Search
    // Divides array into equal-sized blocks
    public static int uniformBinarySearch(int[] arr, int target) {
        int blockSize = (int) Math.sqrt(arr.length);
        int block = arr.length / blockSize;
        
        // Find the block
        int start = 0;
        while (start < arr.length && arr[start] <= target) {
            start += blockSize;
        }
        
        // Search within the block
        int end = Math.min(start, arr.length);
        start = start - blockSize;
        
        for (int i = start; i < end; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
    
    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
    
    // Interpolation Search
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target)
                    return low;
                return -1;
            }
            
            // Position formula
            int pos = low + (((high - low) * 
                    (target - arr[low])) / 
                    (arr[high] - arr[low]));
            
            if (arr[pos] == target)
                return pos;
            
            if (arr[pos] < target)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }
    
    // Fibonacci Search
    public static int fibonacciSearch(int[] arr, int target) {
        int fib2 = 0;  // (n-2)th Fibonacci number
        int fib1 = 1;  // (n-1)th Fibonacci number
        int fib = fib1 + fib2;  // nth Fibonacci number
        
        // Find smallest Fibonacci number greater than or equal to array length
        while (fib < arr.length) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib1 + fib2;
        }
        
        int offset = -1;  // Starting offset
        
        while (fib > 1) {
            // Check if fib2 is valid location
            int i = Math.min(offset + fib2, arr.length - 1);
            
            if (arr[i] < target) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            }
            else if (arr[i] > target) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            }
            else {
                return i;
            }
        }
        
        // Compare last element
        if (fib1 == 1 && arr[offset + 1] == target)
            return offset + 1;
            
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 60, 70, 80, 90};
        int target = 40;
        
        // Test all search methods
        System.out.println("Binary Search: " + 
                binarySearch(arr, target));
                
        System.out.println("Uniform Binary Search: " + 
                uniformBinarySearch(arr, target));
                
        System.out.println("Linear Search: " + 
                linearSearch(arr, target));
                
        System.out.println("Interpolation Search: " + 
                interpolationSearch(arr, target));
                
        System.out.println("Fibonacci Search: " + 
                fibonacciSearch(arr, target));
    }
}