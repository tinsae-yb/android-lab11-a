package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayFlattenerTest {
    @Test
    void flattenArray() {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] input = {{1, 2, 3}, {4, 5, 6}};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = arrayFlattener.flattenArray(input);
        assertArrayEquals(expected, actual);
    }


}