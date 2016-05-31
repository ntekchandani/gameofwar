package gameofwar.tests;

import org.junit.Test;
import org.junit.Assert;

import gameofwar.War;

public class WarTests {
    @Test(expected = IllegalArgumentException.class)
    public final void whenWarPlayedWithLessThan1SuitCountThenExceptionIsThrown() {
        War testWar = new War();
        testWar.play(0,1,2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenWarPlayedWithLessThan1RankCountThenExceptionIsThrown() {
        War testWar = new War();
        testWar.play(1,0,2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenWarPlayedWithLessThan2PlayerCountThenExceptionIsThrown() {
        War testWar = new War();
        testWar.play(1,1,1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenWarMainMethodCalledWithoutAnyArgumentsThenExceptionIsThrown() {
        War.main(new String[] {});
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenWarMainMethodCalledWithTooManyArgumentsThenExceptionIsThrown() {
        War.main(new String[] {"1","2","3","4"});
    }
    
    // TODO: the war class should be tested more robustly.  While refactoring it should 
    // improve testability, there are other ways to overcome its reliance on system in such 
    // as manually setting the input stream.
}