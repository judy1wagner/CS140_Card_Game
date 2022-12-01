//52-Pickup - Programmer: Judy Bagwell
//Created for CS145 at WCC
//This program's purpose it to practice using Classes, Objects, Stacks, Queues,
// ArrayLists, for/catch, enums, git, and GitHub.
//The program itself creates a deck of cards and throws them, then displays where all
//the cards have landed.

public class CardGameMain {
    public static void main(String[] args){
        System.out.println("Do you want to play 52-Pickup?\n");
        Deck myDeck = new Deck();//Creates an instance of the Deck class.
        myDeck.shuffleDeck();//Uses the shuffleDeck method to mix up the cards.
        myDeck.throwCards();//Uses the throwCards method to populate the Queues representing
                            //where the cards have landed.
        System.out.println(myDeck.toString());//Uses the toString method in the Deck class
                                              //to print where all the cards have landed.
        //Originally I wanted to make the user guess where the card were located,
        //and I didn't have time to do that.
        System.out.println("\nGOOD JOB!!!! YOU GOT ALL THE CARDS!!!!");
    }
}

