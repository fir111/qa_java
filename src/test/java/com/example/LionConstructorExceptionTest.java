package com.example;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThrows;

public class LionConstructorExceptionTest {
    @Test
    public void lionConstructorNotCorrectSexTest() {
        Feline feline = new Feline();
        String notCorrectSex = "NotCorrectLion";
        Exception exception = assertThrows(
                Exception.class, () -> new Lion(feline, notCorrectSex));

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String message = exception.getMessage();
        assertThat(message, is(expectedMessage));
    }
}