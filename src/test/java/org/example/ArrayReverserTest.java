package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class ArrayReverserTest {


    @Mock
    ArrayFlattener arrayFlattener;


    @Test
    public void testReverseArray() {
        int[][] arr = new int[][]{{1, 3}, {0}, {4, 5, 9}};
        int[] flatArray = new int[]{1, 3, 0, 4, 5, 9};
        when(arrayFlattener.flattenArray(arr)).thenReturn(flatArray);
        ArrayReverser arrayReverser = new ArrayReverser(arrayFlattener);
        int[] expected = new int[]{9, 5, 4, 0, 3, 1};
        int[] actual = arrayReverser.reverseArray(arr);
        assertArrayEquals(expected, actual);
    }




}