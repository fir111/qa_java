package com.example;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    final private String sex;
    final private boolean hasMane;
    Feline feline;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Lion with sex {0} has a mane {1}")
    public static Object data() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false }
        };
    }

    @Before
    public void setUp(){
        this.feline = Mockito.spy(new Feline());

    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int actualKittensCount = lion.getKittens();
        Mockito.verify(feline, times(1)).getKittens();
        int kittensCount = 1;
        Assert.assertEquals(kittensCount, actualKittensCount);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(hasMane, actualHasMane);

    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        Mockito.verify(feline, times(1)).getFood("Хищник");
        assertThat(expectedFood, is(actualFood));
    }
}