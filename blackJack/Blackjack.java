import java.util.Scanner;

public class Blackjack {
  public static void main(String[] args){

    // welcome message
    System.out.println("Welcome to Blackjack!");

    // create our playing deck
    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();

    // shuffle the deck
    playingDeck.shuffle();

    // Create a deck for the player
    Deck playerDeck = new Deck();

    // create a deck for the dealer
    Deck dealerDeck = new Deck();

    double playerMoney = 100.00;

    Scanner userInput = new Scanner(System.in);

    // Game loop
    while(playerMoney > 0){
      // play On! 
      // Take the players bet
      System.out.println("You have $" + playerMoney + ", how much would you like to bet?");

      // place players input 
      double playerBet = userInput.nextDouble();
      if(playerBet > playerMoney){
        System.out.println("Cannot bet more than you have, Sorry but you are kick out");
        break;
      }

      // Start Dealing
      // Players gets two cards
      playerDeck.draw(playingDeck);
      playerDeck.draw(playingDeck);

      // dealers gets two cards
      dealerDeck.draw(playingDeck);
      dealerDeck.draw(playingDeck);

      while(true){
        System.out.println("Your hand:");
        System.out.println(playerDeck.toString());
      }
      
    }

    System.out.println("Game over! You are out of money. :,( ");

  }
}