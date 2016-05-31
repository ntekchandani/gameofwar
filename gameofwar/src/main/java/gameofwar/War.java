package gameofwar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class War
{
    private static final String HELP_TEXT = "Expected Arguments: [number of suits] [number of ranks] [number of players]";
    private HashMap<Integer,Deck> mPlayerDecks;
    private HashMap<Integer,Deck> mPlayerStakeDecks;
    private TreeSet<Integer> mLivePlayers;
    private int totalPlayers;
    private Scanner mScanner;
    
    public static void main(String[] args) {
        War warGame = new War();
        if(args.length != 3) {
            throw new IllegalArgumentException(HELP_TEXT);
        }
        warGame.play(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
    }
    
    private Card playerAddFaceUpCardToStake(int player) {
        System.out.println("Player " + player + "'s deck size " + mPlayerDecks.get(player).size());
        System.out.print("Player " + player + ", hit enter to stake a face-up card...");
        mScanner.nextLine();
        Card drawnCard = mPlayerDecks.get(player).deal();
        drawnCard.setFaceUp(true);
        mPlayerStakeDecks.get(player).add(drawnCard);
        System.out.println("Player " + player + "'s stakes " + mPlayerStakeDecks.get(player));
        return drawnCard;
    }
    
    private Card playerAddFaceDownCardToStake(int player) {
        System.out.println("Player " + player + "'s deck size " + mPlayerDecks.get(player).size());
        System.out.print("Player " + player + ", hit enter to stake a face-down card...");
        mScanner.nextLine();
        Card drawnCard = mPlayerDecks.get(player).deal();
        drawnCard.setFaceUp(false);
        mPlayerStakeDecks.get(player).add(drawnCard);
        System.out.println("Player " + player + "'s stakes " + mPlayerStakeDecks.get(player));  
        return drawnCard;
    }
    
    private boolean checkPlayerDead(int player) {
        return mPlayerDecks.get(player).isEmpty();
    }
    
    private void eliminatePlayer(int player) {
        mLivePlayers.remove(player);
    }
    
    private void checkAndEliminatePlayer(int player) {
        if(checkPlayerDead(player)) {
            System.out.println("Player " + player + " is out of cards and is eliminated! hit enter");
            mScanner.nextLine();
            eliminatePlayer(player);
        }
    }
    
    private int distributeStakesToBattleWinner(int winningPlayer) {
        int totalWonCards = 0;
        for(int player = 0; player < totalPlayers; player++) {
            if(!mPlayerStakeDecks.get(player).isEmpty()) {
                while(!mPlayerStakeDecks.get(player).isEmpty())
                {
                    totalWonCards++;
                    Card cardWon = mPlayerStakeDecks.get(player).deal();
                    cardWon.setFaceUp(false);
                    mPlayerDecks.get(winningPlayer).add(cardWon);
                }
                mPlayerStakeDecks.get(player).clear();
            }
        }
        return totalWonCards;
    }
  
    
    private void war() {
        //WAR! which is just an extra step of adding a facedown card per player and then another battle
        System.out.println("WAR!"); 
        for(Integer player : mLivePlayers) {
            if(mPlayerDecks.get(player).isEmpty()) {
                System.out.println("Player " + player + " is out of cards during war!");
                continue;
            }
            playerAddFaceDownCardToStake(player);
        }
        System.out.println("Extra war steps complete, time for another battle.");
        battle();
    }
      
    private void battle() {
        //begin a battle
        int topRank = -1;
        int leadPlayer = -1;
        boolean needWar = false;
        for(Integer player : mLivePlayers) {
            if(mPlayerDecks.get(player).isEmpty()) {
                System.out.println("Player " + player + " is out of cards during battle!");
                continue;
            }
            Card drawnCard = playerAddFaceUpCardToStake(player);
            if(drawnCard.getRank() > topRank) {
                topRank = drawnCard.getRank();
                leadPlayer = player;
                needWar = false;
            } else if(drawnCard.getRank() == topRank) {
                needWar = true;
            }
            
        }
        
        if(leadPlayer == -1) {
            //no one wins!
            mLivePlayers.clear();
            return;
        }
        
        if(!needWar) {
            //if there is only one top player this round, they win everything!
            int wonCards = distributeStakesToBattleWinner(leadPlayer);
            System.out.println("Player " + leadPlayer + " wins the round, and " + wonCards + " cards! hit enter");
            mScanner.nextLine();
        } else {
            //otherwise we war!
            war();
        }
        for(int i = 0; i < totalPlayers; i++) {
            if(mLivePlayers.contains(i)) {
                checkAndEliminatePlayer(i);
            }
        }
        if(mLivePlayers.size() == 1) {
            return;
        }
           
    }
    
    public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {
        
        
        if(numberOfSuits < 1) {
            throw new IllegalArgumentException("Must have at least 1 suit");
        }
        
        if(numberOfRanks < 1) {
            throw new IllegalArgumentException("Must have at least 1 rank");
        }
        
        if(numberOfPlayers < 2) {
            throw new IllegalArgumentException("Must have at least 2 players");
        }
        System.out.println("THIS IS WAR!!!!!!!");
        System.out.println("(the card game)");
        System.out.println("Options selected:");
        System.out.println(numberOfSuits + " suits");
        System.out.println(numberOfRanks + " ranks");
        System.out.println(numberOfPlayers + " players");
        System.out.println("Hit enter to begin");
        
        mScanner = new Scanner(System.in);
        mScanner.nextLine();
        totalPlayers = numberOfPlayers;
        
        //Create the master deck and shuffle it
        Deck masterDeck = new QueueDeck();
        masterDeck.create(numberOfSuits,numberOfRanks);
        masterDeck.shuffle();
        
        //Create an empty deck for each player
        //Create an empty 'stake' deck for each player - this contains the cards at risk each round
        //Create a list of livePlayers for state tracking
        mPlayerDecks = new HashMap<Integer,Deck>();
        mPlayerStakeDecks = new HashMap<Integer,Deck>();
        mLivePlayers = new TreeSet<Integer>();
        
        for(int i = 0; i < numberOfPlayers; i++) {
            mPlayerDecks.put(i, new QueueDeck());
            mPlayerStakeDecks.put(i, new QueueDeck());
            mLivePlayers.add(i);
        }
        
        //Deal cards into each players down stack
        while(!masterDeck.isEmpty()) {
            for(int i = 0; i < numberOfPlayers; i++) {
                mPlayerDecks.get(i).add(masterDeck.deal());
                if(masterDeck.isEmpty()) {
                    break;
                }
            }
        }
                
        //Game loop
        while(mLivePlayers.size() > 1) {
            System.out.println("NEW ROUND!");
            battle();
            
        }
        
        if(mLivePlayers.size() == 0) {
            System.out.println("NO ONE WINS!");
        } else {
            System.out.println("Player " + mLivePlayers.iterator().next() + " WINS THE GAME!!!");      
        }
        
    }
}