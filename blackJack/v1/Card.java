// card model
public class Card {
  private Suit suit;
  private Value value;

  // Constructor
  public Card(Suit suit, Value value){
    this.value = value;
    this.suit = suit;
  }

  // method to get the suit and value of the card
  public String toString(){
    return this.suit.toString() + "-" + this.value.toString();
  }

  // a getter to get the value of a card
  public Value getValue(){
    return this.value;
  }
}