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

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                switch (i) {
                    case 0 : {Card c = new Card(j+"S","Schoppen "+j,j); cards.add(c); break;}
                    case 1 : {Card c = new Card(j+"D","Ruiten "+j,j); cards.add(c); break;}
                    case 2 : {Card c = new Card(j+"H","Harten "+j,j); cards.add(c); break;}
                    case 3 : {Card c = new Card(j+"C","Klaveren "+j,j); cards.add(c); break;}
                }
            }
        }
        {Card c = new Card("AH","Harten aas",14); cards.add(c);}
        {Card c = new Card("KH","Harten koning",13); cards.add(c);}
        {Card c = new Card("QH","Harten koningin",12); cards.add(c);}
        {Card c = new Card("JH","Harten boer",11); cards.add(c);}

        {Card c = new Card("AS","Schoppen aas",14); cards.add(c);}
        {Card c = new Card("KS","Schoppen koning",13); cards.add(c);}
        {Card c = new Card("QS","Schoppen koningin",12); cards.add(c);}
        {Card c = new Card("JS","Schoppen boer",11); cards.add(c);}

        {Card c = new Card("AD","Ruiten aas",14); cards.add(c);}
        {Card c = new Card("KD","Ruiten koning",13); cards.add(c);}
        {Card c = new Card("QD","Ruiten koningin",12); cards.add(c);}
        {Card c = new Card("JD","Ruiten boer",11); cards.add(c);}

        {Card c = new Card("AC","Klaver aas",14); cards.add(c);}
        {Card c = new Card("KC","Klaver koning",13); cards.add(c);}
        {Card c = new Card("QC","Klaver koningin",12); cards.add(c);}
        {Card c = new Card("JC","Klaver boer",11); cards.add(c);}

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