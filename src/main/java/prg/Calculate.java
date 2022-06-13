package prg;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class Calculate extends ActionSupport {
    private int number1;
    private int number2;
    private String operator;

    private int result;

    public String execute() {
        switch (operator) {
            case "*":
                result = number1 * number2;
                break;
            case "+":
                result = number1 + number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "^":
                result = (int) Math.pow(number1, number2);
                break;
        }
        return SUCCESS;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }
}
