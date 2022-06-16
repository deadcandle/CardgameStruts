package prg;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class SessionAction extends ActionSupport implements SessionAware {
    private Map<String,Object> session;
    private User user;

    public String execute() {
        addUserToSession();
        if(session.containsKey("user")){
            user = (User) session.get("user");
        }


        return SUCCESS;
    }
    public String addUserToSession() {
        User user = new User("hibernate user 🗿", 20);
        session.put("user", user);
        return SUCCESS;

    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
