package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArrayReverserNullTest {


    @Mock
    ArrayFlattener arrayFlattener;


    @Test
    public void testReverseArray() {
        lenient().when(arrayFlattener.flattenArray(null)).thenReturn(null);
        ArrayReverser arrayReverser = new ArrayReverser(arrayFlattener);

        int[] actual = arrayReverser.reverseArray(null);
        assertNull(actual);
    }


}