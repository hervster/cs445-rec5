package cs445.rec5;

public class DivideAndConquer {

    /**
     * A MinMax object stores both a minimum value and a maximum value.
     */
    public static class MinMax {
        // Instance variables are public for easy access
        public int min = Integer.MAX_VALUE; // Initialize as largest possible int
        public int max = Integer.MIN_VALUE; // Initialize as smallest possible int

        /**
         * Constructor that uses default values
         */
        public MinMax() { }

        /**
         * Constructor that accepts initial min and max, for convenience
         */
        public MinMax(int min, int max) {
            if (min > max) {
                // Make sure client doesn't initialize backward
                throw new IllegalArgumentException("Cannot initialize min to be " +
                        "greater than max");
            }
            this.min = min;
            this.max = max;
        }

        /**
         * Convert to a string for convenient printing
         */
        @Override
        public String toString() {
            return "Min: " + min + "\tMax: " + max;
        }
    }

    /**
     * Swaps two regions within an array. Everything from [start, mid) is
     * swapped with everything in [mid, end). This is the method that does all
     * the work in reverse!
     */
    private static <T> void swapRegions(T[] arr, T[] aux, int start, int mid, int end) {
        // Initialize a variable for where we are copying into in aux
        int i = start;
        // Copy everything from mid to end from a to aux
        for (int j = mid; j < end; j++) {
            aux[i++] = arr[j];
        }
        // Copy everything from start to mid from a to aux
        for (int j = start; j < mid; j++) {
            aux[i++] = arr[j];
        }
        // Copy everything from start to end back from aux to a
        for (int j = start; j < end; j++) {
            arr[j] = aux[j];
        }
    }

    /**
     * Reverses the order of the objects in an array, using divide and conquer
     * recursion. This method is just a wrapper for the helper method.
     *
     * @param arr  The array, whose entries to be reversed.
     */
    public static <T> void reverse(T[] arr) {
        // First, create an auxiliary array for the reversal to happen
        @SuppressWarnings("unchecked")
        T[] aux = (T[])new Object[arr.length];
        // Then, call the helper method that takes bounds
        reverse(arr, aux, 0, arr.length);
    }

    /**
     * Reverses the order of the objects in an array, using divide and conquer
     * recursion. This method is the recursive helper method that takes a start
     * (inclusive) and end (exclusive).
     *
     * @param arr The array to be reversed.
     * @param aux The auxiliary array for the reversal to happen.
     * @param start The first index of arr array.
     * @param end The last index of arr array.
     *
     */
    private static <T> void reverse(T[] arr, T[] aux, int start, int end) {
        // TODO: Complete this method using divide & conquer recursion.

        if (end - start > 1)
        {
            int mid = (start + end)/2;

            // Reverse the first half
            reverse(arr, aux, start, mid);

            // Reverse the second half
            reverse(arr, aux, mid, end);

            swapRegions(arr, aux, start, mid, end);
        }
    }

    /**
     * Determines the minimum and maximum element of an array of ints,
     * using the helper method : findMinMax(int[] nums, int start, int end).
     *
     * @param nums The array to be traversed for max & min integers.
     *
     * @return (Min value, Max value)
     */
    public static MinMax findMinMax(int[] nums) {
        // Call the recursive helper method
        return findMinMax(nums, 0, nums.length);
    }


    /**
     * Determines the minimum and maximum element of an array of ints, using
     * divide & conquer recursion. This is the recursive helper method that
     * takes a start (inclusive) and end (exclusive).
     *
     * @param nums The array to be traversed for max & min integers.
     * @param start The first index of arr array.
     * @param end The last index of arr array.
     *
     * @return (Min value, Max value)
     */
    private static MinMax findMinMax(int[] nums, int start, int end){
        // TODO: Complete this method using divide & conquer recursion.
        // return null;

        if (start+1 == end){ return new MinMax(nums[start], nums[start]); }

        else
        {
            int mid = (start + end)/2;

            MinMax firstHalf = findMinMax(nums, start, mid);
            MinMax secondHalf = findMinMax(nums, mid, end);

            return new MinMax(Math.min(firstHalf.min, secondHalf.min), Math.max(firstHalf.max, secondHalf.max) );
        }
    }
}

