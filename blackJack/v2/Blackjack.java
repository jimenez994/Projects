import java.util.Scanner;

public class Blackjack {
  public static void main(String[] args){

    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();
    playingDeck.shuffle();

    Deck playerDeck = new Deck();

    // create a deck for the dealer
    Deck dealerDeck = new Deck();

    double playerMoney = 100.00;

    Scanner userInput = new Scanner(System.in);

    while(playerMoney > 0){

      playerDeck.draw(playingDeck);
      playerDeck.draw(playingDeck);

      // dealers gets two cards
      dealerDeck.draw(playingDeck);
      dealerDeck.draw(playingDeck);
      playerMoney = 0;
      
      playerDeck = playerDeck.moveAllToDeck(playingDeck);
      dealerDeck = dealerDeck.moveAllToDeck(playingDeck);

    }
    


    System.out.println(playingDeck.toString());

    System.out.println(playerDeck.toString());

    System.out.println(dealerDeck.toString());
    


  }
}