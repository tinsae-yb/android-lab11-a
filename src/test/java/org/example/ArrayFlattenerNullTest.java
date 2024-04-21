package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class ArrayFlattenerNullTest {
    @Test
    void flattenArray() {
        ArrayFlattener arrayFlattener = new ArrayFlattener();

        int[] actual = arrayFlattener.flattenArray(null);
        assertNull( actual);
    }
}