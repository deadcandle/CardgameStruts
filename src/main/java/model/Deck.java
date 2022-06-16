package model;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Deck extends ActionSupport implements SessionAware {
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                switch (i) {
                    case 0 : {Card c = new Card("Clubs",j +" of Clubs",j); cards.add(c); break;}
                    case 1 : {Card c = new Card("Diamonds",j+" of Diamonds",j); cards.add(c); break;}
                    case 2 : {Card c = new Card("Hearts",j+" of Hearts",j); cards.add(c); break;}
                    case 3 : {Card c = new Card("Spades",j+" of Spades",j); cards.add(c); break;}
                }
            }
            Card jack = new Card("Jack", "Jack", 10);
            Card queen = new Card("Queen", "Queen", 11);
            Card king = new Card("King", "King", 12);
            Card ace = new Card("Ace", "Ace", 13);

            cards.add(jack);
            cards.add(queen);
            cards.add(king);
            cards.add(ace);
        }
        Collections.shuffle(cards);
        System.out.println("cards: " + cards.size());
    }

    public Card getNextCard() {
        cards.remove(0);
        return cards.get(0);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public void setSession(Map<String, Object> session) {

    }
}