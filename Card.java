//The Card class defines how a Card object behaves. Basically a
//Card accepts parameters so it's defined, and that information
//can be printed out.

public class Card {
    //Variable defined as private at the beginning
    private int cardRank;
    private String printRank;
    private Suit cardSuit;
    private String printSuit;

    //Constructor method that creates this Card based on the Rank
    //and Suit information it receives as parameters.
    public Card(int cardRank, Suit cardSuit){
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    //The toString method defines how the card is represented as a String.
    public String toString(){
        //This switch case assigns the text to a String depending on
        //the value of the Rank.
        switch (cardRank){
            case 1:
                printRank = "Ace";
                break;
            case 11:
                printRank = "Jack";
                break;
            case 12:
                printRank = "Queen";
                break;
            case 13:
                printRank = "King";
                break;
            default:
                printRank = printRank.valueOf(cardRank);//Converts all the remaining numbers to
                                                        //Strings
                break;
        }
        //This switch case assigns the text to a String depending on the
        //value of each suit
        switch(cardSuit){
            case SPADES:
                printSuit = "Spades";
                break;
            case HEARTS:
                printSuit = "Hearts";
                break;
            case DIAMONDS:
                printSuit = "Diamonds";
                break;
            default:
                printSuit = "Clubs";
        }
        //The method returns the Rank and the Suit as a full String.
        return printRank + " of " + printSuit;
    }
}
