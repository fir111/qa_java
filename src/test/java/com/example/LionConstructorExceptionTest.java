package com.example;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LionConstructorExceptionTest {

    @Test
    public void lionConstructorNotCorrectSexTest() {
        Feline feline = new Feline();
        String notCorrectSex = "TransLion";
        String expectedResult = "Используйте допустимые значения пола животного - самей или самка";
        try{
        new Lion(feline, notCorrectSex);
        }
        catch (Exception thrown) {
            assertThat(expectedResult, is(thrown.getMessage()));
        }
    }
}