package calculator.mafof.com.calculator;

import android.widget.TextView;
import java.util.ArrayList;

public class CalculatePolishNotation extends HandlerGUI {
    private ArrayList<String> stackEquation; // Стек примера
    private boolean isComma = false; // Поставлена ли запятая
    private boolean isMathOperator = true; // Запоминает преведущий тип(оператор/число) СТОИТ TRUE ТАК КАК ПЕРВЫЙ СИМВОЛ ВСЕГДА БАРЬЕР
    private String _temp_number = ""; // Для записи в стек числа

    CalculatePolishNotation(TextView preResult, TextView result) {
        super(preResult, result);
        stackEquation = new ArrayList<>();
    }

    /**
     * Метод добовляющий символ в общий стек и вызов вывода на экран
     * @param operator - входящий символ
     */
    public void add(String operator) {
        // Проверка на ввод одного оператора между цифрами =>
        if (isInputMathOperator(operator) && isMathOperator) return;

        if(isInputMathOperator(operator)) { // Если входящий символ являеться математическим оператором
            addStackEquation(operator);
            isMathOperator = true;
            isComma = false;
        } else { // Если входящий символ являеться цифрой/запятой/скобочкой
            isMathOperator = false;
            if(isBracket(operator)) { // Являеться ли он скобочкой
                addStackEquation(operator);
                isComma = false;
            } else if(operator.equals(".")) { // Если запятая

                if(_temp_number.equals(""))
                    editAddNumberToStack("0.");
                else
                    if(!isComma)
                        editAddNumberToStack(operator);
                isComma = true;
            } else { // если цифра
                editAddNumberToStack(operator);
            }
        }
        MyLog.d(stackEquation.toString());
    }

    /**
     * Добовляет математический оператор
     * @param operator - математический оператор
     */
    private void addStackEquation(String operator) {
        stackEquation.add(operator);
        _temp_number = "";
    }

    /**
     * Добавить/отредактировать число
     * @param number - число
     */
    private void editAddNumberToStack(String number) {
        if(_temp_number.equals("")) {
            _temp_number += number;
            stackEquation.add(_temp_number);
        } else {
            _temp_number += number;
            stackEquation.set(stackEquation.size()-1, _temp_number);
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
}
