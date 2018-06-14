import java.util.ArrayList;
import java.util.Random;

public class Deck {
  ArrayList<Card> cards;

  public Deck(){
    this.cards = new ArrayList<Card>();
  }

  public void createFullDeck(){
    for(Suit cardSuit: Suit.values()){
      for(Value cardValue: Value.values()){
        this.cards.add(new Card(cardSuit, cardValue));
      }
    }
  }

  public void shuffle(){
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    Random random = new Random();
    int randomCardIndex = 0;
    int orginalSize = this.cards.size();
    for(int i = 0; i< orginalSize; i++){
      randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
      tempDeck.add(this.cards.get(randomCardIndex));
      this.cards.remove(randomCardIndex);
    }
    this.cards = tempDeck;
  }

  public String toString(){
    String cardListOutput = "";
    int i = 1;
    for(Card aCard : this.cards){
      cardListOutput += "\n" + i + " " + aCard.toString();
      i++;
    }
    return cardListOutput;    
  }

  public Deck moveAllToDeck(Deck moveTo){
    int thisDeckSize = this.cards.size();

    // put cards into moTo deck
    for(int i = 0; i < thisDeckSize; i++){
      moveTo.addCard(this.getCard(i));
    }
    
    for(int i = 0; i< thisDeckSize; i++){
      this.removeCard(0);
    }
    return this;
  }

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

  public void draw(Deck comingFrom){
    // this will add to the deck or hand that is being use
    this.cards.add(comingFrom.getCard(0));
    // this will remove the card from the comingFrom Deck
    comingFrom.removeCard(0);
  }

    public int cardsValue(){
    int totalValue = 0;
    int aces = 0;

    for(Card aCard : this.cards){
      switch(aCard.getValue()){
        case TWO: totalValue += 2; 
        break;
        case THREE: totalValue += 3; 
        break;
        case FOUR: totalValue += 4; 
        break;
        case FIVE: totalValue += 5; 
        break;
        case SIX: totalValue += 6; 
        break;
        case SEVEN: totalValue += 7; 
        break;
        case EIGHT: totalValue += 8; 
        break;
        case NINE: totalValue += 9; 
        break;
        case TEN: totalValue += 10; 
        break;
        case JACK: totalValue += 10; 
        break;
        case QUEEN: totalValue += 10; 
        break;
        case KING: totalValue += 10; 
        break;
        case ACE: aces += 1; 
        break;
      }
    }

    for(int i = 0; i < aces; i++){
      if(totalValue > 10){
        totalValue += 1;
      }else{
        totalValue += 11;
      }
    }
    return totalValue;
  }

}