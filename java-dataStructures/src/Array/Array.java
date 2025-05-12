package Array;

public class Array {
    
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void secondMaxValOfArr(int[] arr) {
        if (arr.length == 1) {
            System.out.println("Array just has 1 element therefore: ");
            System.out.println("Max = " + arr[0]);
        } else {
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            for (int j : arr) {
                if (j > max) {
                    secondMax = max;
                    max = j;
                } else if (j < max && j > secondMax) {
                    secondMax = j;
                }
            }

            System.out.println("Max = " + max);
            System.out.println("Second max = " + secondMax);
        }
    }

    public static void zeroShifterTOEnd(int[] arr) {
        // assuming arr has some zero values.
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j] == 0 && arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            if (arr[j] != 0) {
                j++;
            }
        }
    }

    public int[] resize(int[] array, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        return temp;
    }
}
