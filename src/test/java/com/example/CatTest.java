package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Feline feline = new Feline();

    @Test
    public void getSound() {
        String expectedSound = "Мяу";
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        assertThat(expectedSound, is(actualSound));
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> catFood = cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertThat(expectedFood, is(catFood));
    }
}