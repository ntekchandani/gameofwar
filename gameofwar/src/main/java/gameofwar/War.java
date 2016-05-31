package gameofwar;

public class War
{
    public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {
        if(numberOfSuits < 1) {
            throw new IllegalArgumentException("Must have at least 1 suit");
        }
    }
}