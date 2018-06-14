import java.util.Scanner;

public class Blackjack {
  public static void main(String[] args){

    // welcome message
    System.out.println("\n --- Welcome to Blackjack! --- \n");

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
      System.out.println("You have $" + playerMoney + ", how much would you like to bet? \n");

      // place players input 
      double playerBet = userInput.nextDouble();
      if(playerBet > playerMoney){
        System.out.println("Cannot bet more than you have, Sorry but you are kick out");
        break;
      }

      boolean endRound = false;

      // Start Dealing
      // Players gets two cards
      playerDeck.draw(playingDeck);
      playerDeck.draw(playingDeck);

      // dealers gets two cards
      dealerDeck.draw(playingDeck);
      dealerDeck.draw(playingDeck);

      while(true){
        System.out.println("Your hand:");
        System.out.println(playerDeck.toString() +"\n");
        // display player's hand
        System.out.println("% Your hand is value at: " + playerDeck.cardsValue() + "\n");    
        
        // display dealer's hand
        System.out.println("Dealer's hand: \n" + dealerDeck.getCard(0).toString() + "\n[Hidden] \n");  
        
        // What does the player want to do?
        System.out.println("Would you like to (1)Hit or (2)Stand?");    
        // input 
        int response = userInput.nextInt();

        // they Hit
        if(response == 1){
          // plaYer draws a card
          playerDeck.draw(playingDeck);
          // this will print the last card drew 
          System.out.println("You draw a:" + playerDeck.getCard(playerDeck.deckSize()-1).toString());
          // bust if > 21
          if(playerDeck.cardsValue() > 21){
            System.out.println("# Bust. Currrent value at: " + playerDeck.cardsValue());
            // players losess money
            playerMoney -= playerBet;
            endRound = true;
            // to exit fo the inner while loop  and stop the player from hitting
            break;
          }
        }
        // player stands , inner while loop stops
        if(response == 2){
          break;
        }
      }

      // Reveal dealers cards
      System.out.println("Dealer Cards: " + dealerDeck.toString() +"\n");
      // see if the dealer has more point than player
      if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false){
        System.out.println("# Dealer beats you!");
        // take players bet
        playerMoney -= playerBet;
        // and of the roud
        endRound = true;
      }
      // dealer braws at 16, stand at 17
      // while dealer has less then 17, dealer keeps drawing
      while((dealerDeck.cardsValue() < 17) && endRound ==false){
        dealerDeck.draw(playingDeck);
        System.out.println("Dealer Draws: "+ dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
      }

      // display total value for dealer
      System.out.println("% Dealer's hand is value at: " + dealerDeck.cardsValue());
      // determine if dealer busted
      if((dealerDeck.cardsValue() > 21) && endRound == false){
        System.out.println("******* Dealer bust! You win ********");
        playerMoney += playerBet;        
        endRound = true;
      }

      // Determine if push
      if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false){
        System.out.println("! Push");
        endRound = true;
      }

      // when player stands and the value of his cards is greater than dealers
      if((playerDeck.cardsValue() >  dealerDeck.cardsValue()) && endRound == false){
        System.out.println("******* You win the hand! *******");
        playerMoney += playerBet;
        endRound = true;
      }else if(endRound == false){
        System.out.println("# You lose the hand.");
        playerMoney -= playerBet;
        endRound = true;
      }

      // after the game move players and dealers deck to playingdeck
      // adding back the cards at the back of the playing deck
      playerDeck = playerDeck.moveAllToDeck(playingDeck);
      dealerDeck = dealerDeck.moveAllToDeck(playingDeck);
      
      

      System.out.println("End of hand.");
      System.out.println("-----------------------");      
    }
    // game is over
    System.out.println("Game over! You are out of money. :,( ");

    // close Scanner
    userInput.close();

  }
}