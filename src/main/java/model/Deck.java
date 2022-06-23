package model;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Deck extends ActionSupport {
    Map<String, Object> session;
    private int totalCards;
    private ArrayList<Card> cards = new ArrayList<>();

    // blijkbaar gebruikt de API 0 als 10, dus 0D is ruiten 10
    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                switch (i) {
                    case 0 : {Card c = new Card(j+"S","ace "+j,j); cards.add(c); break;}
                    case 1 : {Card c = new Card(j+"D","spade "+j,j); cards.add(c); break;}
                    case 2 : {Card c = new Card(j+"H","diamonds "+j,j); cards.add(c); break;}
                    case 3 : {Card c = new Card(j+"C","clover "+j,j); cards.add(c); break;}
                }
            }
        }
        {Card c = new Card("AH","ace of hearts",14); cards.add(c);}
        {Card c = new Card("KH","Harten koning",13); cards.add(c);}
        {Card c = new Card("QH","Harten koningin",12); cards.add(c);}
        {Card c = new Card("JH","Harten boer",11); cards.add(c);}

        {Card c = new Card("AS","ace of spades",14); cards.add(c);}
        {Card c = new Card("KS","king of spades",13); cards.add(c);}
        {Card c = new Card("QS","queen of spades",12); cards.add(c);}
        {Card c = new Card("JS","jack of spades",11); cards.add(c);}

        {Card c = new Card("AD","ace of diamond",14); cards.add(c);}
        {Card c = new Card("KD","king of diamonds",13); cards.add(c);}
        {Card c = new Card("QD","queen of diamonds",12); cards.add(c);}
        {Card c = new Card("JD","jack of diamonds",11); cards.add(c);}

        {Card c = new Card("AC","ace of clovers",14); cards.add(c);}
        {Card c = new Card("KC","king of clovers",13); cards.add(c);}
        {Card c = new Card("QC","queen of clovers",12); cards.add(c);}
        {Card c = new Card("JC","jack fo clovers",11); cards.add(c);}

        Collections.shuffle(cards);
        totalCards = cards.size();
    }

    public Card getNextCard() {
        cards.remove(0);
        totalCards = cards.size();
        return cards.get(0);
    }

    public ArrayList<Card> getCards() {return cards;}
    public int getTotalCards() {return totalCards;}
}