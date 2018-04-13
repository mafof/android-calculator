package calculator.mafof.com.calculator.polishwrite;

import java.util.ArrayList;

public class Calc extends StacksPriority {

    private ArrayList<String> stackResult; // Стек результата
    private ArrayList<String> stackTehas;  // Стек техаса
    private ArrayList<String> stackEquation;
    private int iteratorForStackEquation = 0;

    protected void calculate(ArrayList<String> stackEquation) {
        stackTehas = new ArrayList<>();
        stackResult = new ArrayList<>();
        this.stackEquation = stackEquation;
        stackTehas.add("BREAK");
        prioritet(stackEquation.get(iteratorForStackEquation));
    }

    private void prioritet(String element) {
        String stackElement = stackTehas.get(stackTehas.size()-1);
        if(stackOneIn(element) && stackOneOut(stackElement)) {
            action(2);
        } else if(stackTwoIn(element) && stackTwoOut(stackElement)) {
            action(1);
        } else if(stackThree(element) && stackThree(stackElement)) {
            action(2);
        } else if(stackFourIn(element) && stackFourOut(stackElement)) {
            action(1);
        } else if(stackFiveIn(element) && stackFiveOut(stackElement)) {
            action(2);
        } else if(stackSixIn(element) && stackSixOut(stackElement)) {
            action(1);
        } else if(stackSevenIn(element) && stackSevenOut(stackElement)) {
            action(1);
        } else if(element.equals("BREAK") && stackElement.equals("BREAK")) {
            action(4);
        } else if(element.equals(")") && stackElement.equals("BREAK")) {
            action(5);
        } else if(element.equals("BREAK") && stackElement.equals("(")) {
            action(5);
        } else if(element.equals(")") && stackElement.equals("(")) {
            action(3);
        }
    }

    private void action(int type) {}

    private void next() {}
}
