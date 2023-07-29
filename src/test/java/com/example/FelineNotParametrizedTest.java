package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class FelineNotParametrizedTest {
    @Spy
    Feline feline;

    @Test
    public void eatMeat() throws Exception {
        List<String> felineFood = feline.eatMeat();
        List<String> expectedFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertThat(expectedFood, is(felineFood));
    }

    @Test
    public void getFamily() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void getKittens() {
        int expectedKittensCount = 1;
        int kittensCount = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        Assert.assertEquals(expectedKittensCount, kittensCount);
    }
}