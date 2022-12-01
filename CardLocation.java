//This class represents where each card has landed. The behavior is to receive
//the card information as a parameter, populate a Queue with each card it receives
//and then print them out separated by semi-colons.

import java.util.LinkedList;
import java.util.Queue;

public class CardLocation {
    //Variables set to private
    private Queue<Card> locationOfCards = new LinkedList<>();
    private String cardsToPrint = "";

    //Constructor method defines that this instance of the location is equal to
    //wherever the cards are located.
    public CardLocation(){
        this.locationOfCards = getLocationOfCards();
    }

    //Accessor method to let us access the information that is in the Queue
    public Queue<Card> getLocationOfCards() {
        return locationOfCards;
    }

    //Mutator method accepts a Card object as a parameter and adds it
    //to the Queue
    public void setLocationOfCards(Card thrownCards){
        locationOfCards.add(thrownCards);
    }

    //String method defines how this location prints out
    public String toString(){
        //While loop to only do the following tasks while the Queue has Cards stored in it
        while(!locationOfCards.isEmpty()) {
            //This nested for loop accesses the information in the Queue one card at and prints
            //them out in rows of four. It needs a sentinel value somewhere, and I haven't figured
            //that out yet.
            //QUESTION: I wasn't sure if it's good practice to use a non-encapsulated variable
            //here for j. Should it be defined at the top as private?
            for (int j = 0; j < locationOfCards.size(); j++) {
                //Because the program will break if we have less than four Cards left in the Queue
                //I used a try/catch statement to handle when there's Cards missing at the end
                try {
                    for (int i = 0; i < 4; i++) {
                        //This statement adds the next Card to the line to print
                        cardsToPrint = cardsToPrint + " " + locationOfCards.remove().toString() + ";";
                    }
                    //QUESTION: I wasn't sure which exception to use.
                } catch (Exception e) {
                    //By this time, the Queue is small enough that it will fit on one row, so we can just
                    //say print out all the cards left in the Queue
                    for (int i = 0; i < locationOfCards.size(); i++) {
                        cardsToPrint = cardsToPrint + " " + locationOfCards.remove().toString() + ";";
                    }
                }
                //Now the rows of cards are all assigned to print when the variable cardsToPrint is called.
                cardsToPrint = cardsToPrint + "\n";
            }
        }
            return cardsToPrint;
        }
    }
