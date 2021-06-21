package cs445.rec5;

public class Recursion {

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
     * Swaps two indexes in the array. Useful for reverse.
     */
    static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Reverses the order of the objects in an array, using
     * recursion. This method is just a wrapper for the helper method.
     *
     * @param arr  The array, whose entries to be reversed.
     */
    public static <T> void reverse(T[] arr) {
        reverse(arr, 0, arr.length);
    }

    /**
     * Reverses the order of the objects in an array, using
     * recursion. This method is the recursive helper method that takes a start
     * (inclusive) and end (exclusive).
     *
     * @param arr The array to be reversed.
     * @param start The first index of arr array.
     * @param end The last index of arr array.
     */
    private static <T> void reverse(T[] arr, int start, int end) {
        // TODO: Complete this method using recursion.

        if (end > start) 
        {
            // Swapping 1st elem with last elem
            swap(arr, start, end-1);
            // Decrease swap space (eliminate swapped elements)
            reverse(arr, start+1, end-1);
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
     * recursion. This is the recursive helper method that
     * takes a start (inclusive) and end (exclusive).
     *
     * @param nums The array to be traversed for max & min integers.
     * @param start The first index of arr array.
     * @param end The last index of arr array.
     *
     * @return (Min value, Max value)
     */
    private static MinMax findMinMax(int[] nums, int start, int end){
        // TODO: Complete this method using recursion.

        if ( start+1 == end) { return new MinMax(nums[start], nums[start]); }

        else
        {
            MinMax curr = findMinMax(nums, start+1, end);
            return new MinMax( Math.min(nums[start], curr.min), Math.max(nums[start], curr.max) );
        }
        // return null;
    }

}

