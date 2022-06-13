package prg;

import com.opensymphony.xwork2.ActionSupport;
public class WelcomeAction extends ActionSupport {
    private String input;
    private String output;
    public String execute() {
        return SUCCESS;
    }


}
