package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Db_connectie;
import model.Deck;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class WelcomeAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private int totalCards = 50;

    public String execute() {
        session.clear();
        session.putIfAbsent("deck", new Deck());
        session.putIfAbsent("currentCard", ((Deck) session.get("deck")).getNextCard());
        session.putIfAbsent("nextCard", ((Deck) session.get("deck")).getNextCard());
        session.putIfAbsent("score", 0);
        session.putIfAbsent("db", new Db_connectie());
        return SUCCESS;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    public int getTotalCards() {
        return totalCards;
    }
    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}