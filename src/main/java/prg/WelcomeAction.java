package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Deck;
import model.OpslaanDB;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WelcomeAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private OpslaanDB opslaanDB;


    public String execute() {
        session.putIfAbsent("deck", new Deck());
        session.putIfAbsent("currentCard", ((Deck) session.get("deck")).getNextCard());
        session.putIfAbsent("nextCard", ((Deck) session.get("deck")).getNextCard());
        session.putIfAbsent("score", 0);
        return SUCCESS;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public OpslaanDB getOpslaanDB() {
        return opslaanDB;
    }

    public void setOpslaanDB(OpslaanDB opslaanDB) {
        this.opslaanDB = opslaanDB;
    }
}