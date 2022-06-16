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
                    case 0 : {Card c = new Card("Schoppen",j+"Schoppen", j); cards.add(c); break;}
                    case 1 : {Card c = new Card("Ruiten",j+"Ruiten",j); cards.add(c); break;}
                    case 2 : {Card c = new Card("Harten",j+"Harten",j); cards.add(c); break;}
                    case 3 : {Card c = new Card("Klaveren",j+"Klaveren",j); cards.add(c); break;}
                }
            }
            Card jack = new Card("Boer", "Boer", 10);
            Card queen = new Card("Vrouw", "Vrouw", 11);
            Card king = new Card("Koning", "Koning", 12);
            Card ace = new Card("Aas", "Aas", 13);

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