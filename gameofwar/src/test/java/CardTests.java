package gameofwar.tests;

import org.junit.Test;
import gameofwar.Card;

public class CardTests {
    @Test(expected = IllegalArgumentException.class)
    public final void whenCardCreatedWithNegativeRankThenExceptionIsThrown() {
        Card testCard = new Card(-1,1);
    }
}