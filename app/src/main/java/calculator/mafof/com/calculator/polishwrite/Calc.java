package calculator.mafof.com.calculator.polishwrite;

import java.util.ArrayList;

import calculator.mafof.com.calculator.MyLog;

public class Calc extends StacksPriority {

    private ArrayList<String> stackResult; // Стек результата(стек калифорнии)
    private ArrayList<String> stackTehas;  // Стек техаса
    private ArrayList<String> stackEquation; // Входящий стек(стек примера)

    public void calculate(ArrayList<String> stackEquation) {
        stackTehas = new ArrayList<>();
        stackResult = new ArrayList<>();
        this.stackEquation = stackEquation;

        stackTehas.add("BREAK");
        this.stackEquation.add("BREAK");

        calc(this.stackEquation);

        // Дебаг =>
        /*
        StringBuilder _result = new StringBuilder();
        for(String ch : stackResult) _result.append(" " + ch);
        MyLog.d(_result.toString());
        */
    }

    private void calc(ArrayList<String> stackEquation) {
        prioritet(stackEquation.get(0));
    }

    private void prioritet(String element) {
        String stackElement = stackTehas.get(stackTehas.size() - 1);

        if(isNumeric(element)){
            stackResult.add(element);
            next();
        } else if(stackOneIn(element) && stackOneOut(stackElement)) {
            action(2, element);
        } else if(stackTwoIn(element) && stackTwoOut(stackElement)) {
            action(1, element);
        } else if(stackThree(element) && stackThree(stackElement)) {
            action(2, element);
        } else if(stackFourIn(element) && stackFourOut(stackElement)) {
            action(1, element);
        } else if(stackFiveIn(element) && stackFiveOut(stackElement)) {
            action(2, element);
        } else if(stackSixIn(element) && stackSixOut(stackElement)) {
            action(1, element);
        } else if(stackSevenIn(element) && stackSevenOut(stackElement)) {
            action(1, element);
        } else if(element.equals("BREAK") && stackElement.equals("BREAK")) {
            action(4, element);
        } else if(element.equals(")") && stackElement.equals("BREAK")) {
            action(5, element);
        } else if(element.equals("BREAK") && stackElement.equals("(")) {
            action(5, element);
        } else if(element.equals(")") && stackElement.equals("(")) {
            action(3, element);
        }
    }

    /**
     * Метод в котором производиться вся логика действий
     * @param type - тип действия
     * @param element - входящий элемент(символ стрелки)
     */
    private void action(int type, String element) {
        switch (type) {
            case 1:
                stackTehas.add(element);
                next();
                break;
            case 2:
                stackResult.add(stackTehas.remove(stackTehas.size()-1));
                prioritet(stackEquation.get(0));
                break;
            case 3:
                stackTehas.remove(stackTehas.size()-1);
                next();
                break;
            case 4:
                break;
            case 5:
                MyLog.d(new Error("EXAMPLE NOT VALID").toString());
                break;
        }
    }

    private void next() {
        stackEquation.remove(0);
        prioritet(stackEquation.get(0));
    }

    /**
     * Метод проверяющий являеться ли аргумент числом
     * @param str - входящий аргумент
     */
    protected boolean isNumeric(String str) { return str.matches("((-|\\+)?[0-9]+(\\.+)?)+"); }
}
