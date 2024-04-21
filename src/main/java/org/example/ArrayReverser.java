package org.example;

public class ArrayReverser {

    private final ArrayFlattener arrayFlattener;

    public ArrayReverser(ArrayFlattener arrayFlattener) {
        this.arrayFlattener = arrayFlattener;
    }


    public int[] reverseArray(int[][] arr) {
        if (arr == null) {
            return null;
        }
        int[] flatArray = arrayFlattener.flattenArray(arr);
        int[] reversedArray = new int[flatArray.length];
        for (int i = 0; i < flatArray.length; i++) {
            reversedArray[i] = flatArray[flatArray.length - 1 - i];
        }
        return reversedArray;
    }
}
