package org.example;

public class ArrayFlattener {
    public int[] flattenArray(int[][] arr) {
        if (arr == null) {
            return null;
        }
        int totalLength = 0;
        for (int[] subArray : arr) {
            totalLength += subArray.length;
        }
        int[] result = new int[totalLength];
        int index = 0;
        for (int[] subArray : arr) {
            for (int num : subArray) {
                result[index++] = num;
            }
        }
        return result;
    }
}
