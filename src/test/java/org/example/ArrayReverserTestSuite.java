package org.example;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("ArrayReverser Test Suite")
@SelectClasses({ArrayReverserTest.class, ArrayReverserNullTest.class})
public class ArrayReverserTestSuite {
}
