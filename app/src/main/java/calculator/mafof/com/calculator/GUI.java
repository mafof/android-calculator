package calculator.mafof.com.calculator;

import android.widget.TextView;

import java.util.ArrayList;

import calculator.mafof.com.calculator.polishwrite.Calc;

public class GUI extends Calc {
    private TextView preResult;
    private TextView result;
    private StringBuilder preResultText;
    private ArrayList<String> stackEquation;

    GUI(TextView preResult, TextView result) {
        stackEquation = new ArrayList<>();
        this.preResult = preResult;
        this.result = result;
    }

    public ArrayList<String> getStackEquation() { return stackEquation; }

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
        drawPreResult(stackEquation);
    }

    /**
     * Метод удаляющий в элементе 1 символ
     */
    public void backspace() {
        String _element = stackEquation.get(stackEquation.size()-1);
        MyLog.d(_element.length());
        if(_element.length() > 1) {
            _element = _element.substring(0, _element.length()-1);
            stackEquation.set(stackEquation.size()-1, _element);
        } else {
            stackEquation.remove(stackEquation.size()-1);
        }
        drawPreResult(stackEquation);
    }

    /**
     * Метод очищающий уравнение
     */
    public void clear() {
        stackEquation.clear();
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

    private void drawPreResult(ArrayList<String> stackEquation) {
        preResultText = new StringBuilder();
        for(String el: stackEquation)
            preResultText.append(el);
        preResult.setText(preResultText);
        if(stackEquation.size() >= 1) calculate(stackEquation);
    }
}
