package calculator.mafof.com.calculator;

import android.widget.TextView;
import java.util.ArrayList;

public class CalculatePolishNotation extends HandlerGUI {
    private ArrayList<String> stackEquation; // Стек примера

    CalculatePolishNotation(TextView preResult, TextView result) {
        super(preResult, result);
        stackEquation = new ArrayList<>();
    }

    /**
     * Метод добовляющий символ в общий стек и вызов вывода на экран
     * @param inputData - входящий символ
     */
    public void add(String inputData) {
        if(stackEquation.isEmpty()) {
            if(!isInputMathOperator(inputData) && !inputData.equals(".")) stackEquation.add(inputData);
            else if(inputData.equals(".")) stackEquation.add("0.");
        } else {
            checkNumber(inputData);
        }
        //MyLog.d(stackEquation.toString());
        drawPreResult(stackEquation);
    }

    /**
     * Проверка входящего символа
     * @param number = входящий символ
     */
    private void checkNumber(String number) {
        String preNumber = stackEquation.get(stackEquation.size()-1);
        if(isInputMathOperator(number) || isBracket(number)) stackEquation.add(number);
        else if(number.equals(".")) {
            if(isNumeric(preNumber)) { // Если последний символ в стеке являеться числом
                if(!preNumber.contains(".")) { // Если последний элемент в стеке не имеет точку
                    preNumber += number;
                    stackEquation.set(stackEquation.size()-1, preNumber);
                }
            } else {
                stackEquation.add("0.");
            }
        } else { // Если входящий аргумент число
            if(isNumeric(preNumber)) { // Если последний символ в стеке число
                preNumber += number;
                stackEquation.set(stackEquation.size()-1, preNumber);
            } else { // Если последний символ в стеке не число
                stackEquation.add(number);
            }
        }
    }

    /**
     * Метод проверяющий являеться ли аргумент числом
     * @param str - входящий аргумент
     */
    private boolean isNumeric(String str) { return str.matches("((-|\\+)?[0-9]+(\\.+)?)+"); }

    /**
     * Метод определяющий являеться ли аргумент математическим оператором
     * @param operator - входящее значение
     */
    private boolean isInputMathOperator(String operator) {
        switch (operator) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
        }
        return false;
    }

    /**
     * Метод определяющий являеться ли аргумент скобками
     * @param bracket - входящий элемент
     */
    private boolean isBracket(String bracket) {
        switch (bracket) {
            case "(":
            case ")":
                return true;
        }
        return false;
    }
}
