package model;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Card extends ActionSupport implements SessionAware {
    private String suit;
    private String name;
    private int value;

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
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

    public int getValue() {
        return value;
    }

    @Override
    public void setSession(Map<String, Object> session) {

    }
}