package prg;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 4; i++) {

            String suit = "niks";
            switch (i) {
                case 0:
                    suit = "Harten";
                    break;
                case 1:
                    suit = "Ruiten";
                    break;
                case 2:
                    suit = "Schoppen";
                    break;
                case 3:
                    suit = "Klaver";
                    break;
            }

            for (int j = 2; j <= 10; j++) {
                Card c = new Card(suit, " " + j, j);
                cards.add(c);
            }

            Card boer = new Card(suit, "Boer "  + 11,  11);
            Card vrouw = new Card(suit, "Vrouw " + 12, 12);
            Card koning = new Card(suit, "Koning " + 13, 13);
            Card aas = new Card(suit, "Aas " + 14, 14);

            cards.add(boer);
            cards.add(vrouw);
            cards.add(koning);
            cards.add(aas);
        }

        Collections.shuffle(cards);
    }

    public Card getNextCard() {
        int next = 0;
        Card nextCard = cards.remove(next);
        return nextCard;
    }

    public ArrayList<Card> getCards() {
        return cards;

    }

}
