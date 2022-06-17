package model;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Card extends ActionSupport {

    private Map<String, Object> session;
    private String suit; // code, bijvoorbeeld "KS" -> KING SPADES
    private String name;
    private int value;

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public boolean isHigherOrEqual(Card c) {
        if (value >= c.value) {
            return true;
        }
        return false;
    }

    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}