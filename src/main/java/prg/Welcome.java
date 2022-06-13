package prg;

import com.opensymphony.xwork2.ActionSupport;
public class Welcome extends ActionSupport {
    private String input;
    private String output;
    public String execute() {
        return SUCCESS;
    }


}
