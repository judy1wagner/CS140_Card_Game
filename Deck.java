//This is the Deck class, which does most of the work.

import java.util.*;

public class Deck {
    //Variables uses assigned as private at the top.
    private ArrayList<Card> cardsInOrder = new ArrayList<>();
    private Stack<Card> shuffledDeck = new Stack<>();
    //QUESTION: Should I have two Random objects? I wonder if I could have one
    //and use it in two places.
    private Random shuffleTool = new Random();
    private Random throwTool = new Random();
    private CardLocation underTheTable = new CardLocation();
    private CardLocation onTheBookcase = new CardLocation();
    private CardLocation onTheRug = new CardLocation();
    private CardLocation inTheKitchen = new CardLocation();
    private CardLocation outsideInTheYard = new CardLocation();
    private CardLocation onTheDog = new CardLocation();
    private CardLocation behindTheFridge = new CardLocation();


    //This constructor assigns the 52 values of the Cards into an
    //  in order.
    public Deck(){
        //The four loop runs 13 times. Each time it loops, it adds the next
        //number of each suit to the ArrayList
        for (int i = 0; i<13; i++){
            cardsInOrder.add(new Card(i+1,Suit.SPADES));//add a 1 of Spades, then a 2, etc.
            cardsInOrder.add(new Card(i+1,Suit.HEARTS));//add a 1 Hearts, etc.
            cardsInOrder.add(new Card(i+1,Suit.DIAMONDS));//add a 1 of Diamonds, etc.
            cardsInOrder.add(new Card(i+1,Suit.CLUBS));//add a 1 of Clubs, etc.
        }
    }

    //The shuffleDeck method randomly pulls cards from the ArrayList and puts them in a Stack
    public void shuffleDeck (){
        //This while loop randomly removes the cards from the cardsInOrder ArrayList
        //and puts them into a Stack of shuffled Cards. It removes the value from the
        //ArrayList each time around so that it stops when the ArrayList is empty
        while(!cardsInOrder.isEmpty()) {
            int location = shuffleTool.nextInt(cardsInOrder.size());
            shuffledDeck.push(cardsInOrder.get(location));
            cardsInOrder.remove(location);
        }
    }

    //The throwCards method pulls the cards from the Stack of shuffled Cards and
    //Randomly puts them in the Queues that represent the location of the card.
    public void throwCards(){
        //The try catch is necessary here just to assure the compiler that the
        //loop will work.
        try {
            while(!shuffledDeck.isEmpty()){
                //Pick a random number from 0-6.
                int i = throwTool.nextInt(7);
                //Depending on the value of the Random number, put
                //the Card in a different location (instance of the CardLocation class).
                switch (i) {
                    case 6:
                        //<CardLocation>.<setMethod>.(<the Card popped from the stack>);
                        underTheTable.setLocationOfCards(shuffledDeck.pop());
                        break;
                    case 5:
                        onTheBookcase.setLocationOfCards(shuffledDeck.pop());
                        break;
                    case 4:
                        onTheRug.setLocationOfCards(shuffledDeck.pop());
                        break;
                    case 3:
                        inTheKitchen.setLocationOfCards(shuffledDeck.pop());
                        break;
                    case 2:
                        outsideInTheYard.setLocationOfCards(shuffledDeck.pop());
                        break;
                    case 1:
                        onTheDog.setLocationOfCards(shuffledDeck.pop());
                        break;
                    case 0:
                        behindTheFridge.setLocationOfCards(shuffledDeck.pop());
                        break;
                }
            }
        } catch (Exception e){
        }
    }

    //This getMethod is specific to getting the location of the the Cards, rather than
    //the whole deck.
    //QUESTION: Is it appropriate to have this method in the Deck class? I don't even know if I ended up
    //using this method in the end now that I think of it.
    public Queue<Card> getThrownCards(CardLocation whichLocation){
        return whichLocation.getLocationOfCards();
    }

    //This toString method assigns the text to print out for the whole deck. It's specific to the location
    //though, which I think is weird. What if the shuffleDeck and throwCards methods haven't been used?
    //Nothing would print.
    public String toString (){
            //QUESTION: Is it bad practice to define these String variables here?
            String table;
            String bookcase;
            String rug;
            String kitchen;
            String yard;
            String dog;
            String fridge;

            //For of the if else statement below, it says what to print if the Queue has
            //cards in it, and otherwise print a message that it has no cards.
            if (!underTheTable.getLocationOfCards().isEmpty()) {
                table = "Go get the cards under the table:\n" + underTheTable.toString();
            } else {
                table = "There are no cards under the table.";
            }
            if (!onTheBookcase.getLocationOfCards().isEmpty()) {
                bookcase = "Go get the cards on the bookcase:\n" + onTheBookcase.toString();
            } else {
                bookcase = "There are no cards on the bookcase.";
            }
            if (!onTheRug.getLocationOfCards().isEmpty()) {
                rug = "Go get the cards on the rug:\n" + onTheRug.toString();
            } else {
                rug = "There are no cards on the rug.";
            }
            if (!inTheKitchen.getLocationOfCards().isEmpty()) {
                kitchen = "Go get the cards in the Kitchen:\n" + inTheKitchen.toString();
            } else {
                kitchen = ("There are no cards in the kitchen.");
            }
            if (!outsideInTheYard.getLocationOfCards().isEmpty()) {
                yard = "Go get the cards outside in the yard:\n" + outsideInTheYard.toString();
            } else {
                yard = ("There are no cards outside in the yard.");
            }
            if (!onTheDog.getLocationOfCards().isEmpty()) {
                dog = "Go get the cards on the dog:\n" + onTheDog.toString();
            } else {
                dog = "There are no cards on the Dog.";
            }
            if (!behindTheFridge.getLocationOfCards().isEmpty()) {
                fridge = "Go get the cards behind the fridge:\n" + behindTheFridge.toString();
            } else {
                fridge = "There are no cards behind the fridge.";
            }

            //returns all the locations in rows as Strings
            return (table + "\n\n" + bookcase + "\n\n" + rug + "\n\n" + kitchen
                    + "\n\n" + yard + "\n\n" + dog + "\n\n" + fridge);
        }
    }



