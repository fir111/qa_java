package com.example;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int kittensCount;
    private final int expectedResult;

    public FelineParametrizedTest(int kittensCount, int expectedResult) {
        this.kittensCount = kittensCount;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Feline family with {0} kittens should have {1} kittens")
    public static Object data() {
        return new Object[][] {
                { 2, 2 },
                { 0, 0 },
                { -2, -2 }
        };
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(kittensCount);
        Assert.assertEquals(expectedResult, actualResult);
    }
}