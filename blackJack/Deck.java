import java.util.ArrayList;
import java.util.Random;

public class Deck {

  // instans of Card
  private ArrayList<Card> cards;

  // constructor
  public Deck(){
    this.cards = new ArrayList<Card>();
  }

  public void createFullDeck(){
    // generate 52 Cards (4 x 13)
    // it will iterated through each suit (4 suits) from the enums
    for(Suit cardSuit: Suit.values()){
      // its iterating through the values (13 values) from the enums
      for(Value cardValue : Value.values()){
        // add a new card to the mix
        // using the card contructor create a new card
        this.cards.add(new Card(cardSuit, cardValue));
      }
    }
  }
  // shuffle Deck of cards
  public void shuffle(){
    // temp arrayList
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    // use random 
    Random random = new Random();
    int randomCardIndex = 0;

    // using orginal size for safety to do the for loop properly since the array will be changin size 
    int orginalSize = this.cards.size();
    for(int i = 0; i< orginalSize; i++){
      // generate random Index rand.nextInt((max - min) + 1) min ;
      // it will pull a random card from the orginal dec and push it to the temp array until orginal deck is empty
      // random number
      randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
      // random card -> add to temp deck
      tempDeck.add(this.cards.get(randomCardIndex));

      // remove from original deck
      this.cards.remove(randomCardIndex);
    }
    // orginal deck is now the temp shuffled deck
    this.cards = tempDeck;
  }

  // this will return the list of cards on a string format 
  public String toString(){
    String cardListOutput = "";
    // this will iterate from the list of cards and add it to the string 
    for(Card aCard : this.cards){
      cardListOutput += "\n" + aCard.toString();
    }
  return cardListOutput;    
  }

  // removes a card at index i
  public void removeCard(int i){
    this.cards.remove(i);
  }

  // get card at index i
  public Card getCard(int i){
    return this.cards.get(i);
  }

  // add card to deck
  public void addCard(Card addCard){
    this.cards.add(addCard);
  }

  // Draws from the deck
  // this will add a crad from one deck to another in this case the players hand
  // 
  public void draw(Deck comingFrom){
    // this will add to the deck or hand that is being use
    this.cards.add(comingFrom.getCard(0));
    // this will remove the card from the comingFrom Deck
    comingFrom.removeCard(0);
  }
}