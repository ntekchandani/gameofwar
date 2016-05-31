package gameofwar.tests;

import org.junit.Test;
import org.junit.Assert;

import gameofwar.War;

public class WarTests {
    @Test(expected = IllegalArgumentException.class)
    public final void whenWarPlayedWithLessThan1SuitCountThenExceptionIsThrown() {
        War testWar = new War();
        testWar.play(0,1,1);
    }
}