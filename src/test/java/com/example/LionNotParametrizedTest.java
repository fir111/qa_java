package com.example;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionNotParametrizedTest {
    @Mock
    Feline felineMock;
    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");

        int expectedKittensCount = 10;
        Mockito.when(felineMock.getKittens()).thenReturn(expectedKittensCount);

        int actualKittensCount = lion.getKittens();
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");

        List<String> expectedFood = List.of("Животные", "Птицы");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();
        assertThat(expectedFood, is(actualFood));
    }
}