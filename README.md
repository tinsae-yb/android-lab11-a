<h1>I am using JUNIT 5 -  this could be different from the slides </h1>

<h1>My Array flattener class</h1>

```java
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

```

<h1>My Array flattener test classes</h1>

```java
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

```

```java
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
```

<h2>My array flattener test suite</h2>

```java
package org.example;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({ArrayFlattenerTest.class, ArrayFlattenerNullTest.class})
@SuiteDisplayName("ArrayFlattener Test Suite")
public class ArrayFlattenerTestSuite {


}

```


<h1>My Array reverser class</h1>

```java

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

``` 

<h1>My Array reverser test classes</h1>

```java
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

```

```java
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
```

<h2>My array reverser test suite</h2>

```java
package org.example;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("ArrayReverser Test Suite")
@SelectClasses({ArrayReverserTest.class, ArrayReverserNullTest.class})
public class ArrayReverserTestSuite {
}

```