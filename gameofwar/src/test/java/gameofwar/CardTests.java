package gameofwar.tests;

import org.junit.Test;
import org.junit.Assert;

import gameofwar.Card;

public class CardTests {
    @Test(expected = IllegalArgumentException.class)
    public final void whenCardCreatedWithNegativeRankThenExceptionIsThrown() {
        Card testCard = new Card(-1,1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenCardCreatedWithNegativeSuitThenExceptionIsThrown() {
        Card testCard = new Card(1,-1);
    }
    
    @Test
    public final void whenCardCreatedThenGetCorrectSuitAndRank() {
        Card testCard = new Card(1,2);
        Assert.assertEquals(1,testCard.getSuit());
        Assert.assertEquals(2,testCard.getRank());
    }
    
    @Test
    public final void whenCardStateSetGetDefaultStateFaceDown() {
        Card testCard = new Card(1,2);
        Assert.assertEquals(false,testCard.isFaceUp());
    }
    
    @Test
    public final void whenCardStateSetGetCorrectStateBack() {
        Card testCard = new Card(1,2);
        testCard.setFaceUp(true);
        Assert.assertEquals(true,testCard.isFaceUp());
    }
}