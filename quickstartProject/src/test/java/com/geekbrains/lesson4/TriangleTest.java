package com.geekbrains.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void positiveCalcTriangleAreaTest() throws Exception {
        Assertions.assertEquals(Triangle.calcTriangleArea(3, 4, 5), 6);
    }

    @Test
    void negativeCalcTriangleAreaTest() {
       Assertions.assertAll(
                () -> Assertions.assertThrows(Exception.class, () -> Triangle.calcTriangleArea(-7, 8, 9)),
                () -> Assertions.assertThrows(Exception.class, () -> Triangle.calcTriangleArea(1, 2, 3))
        );
    }
}
