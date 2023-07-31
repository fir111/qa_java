package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LionConstructorExceptionTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Test
    public void lionConstructorNotCorrectSexTest() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самей или самка");

        Feline feline = new Feline();
        String notCorrectSex = "NotCorrectLion";
        new Lion(feline, notCorrectSex);
    }
}