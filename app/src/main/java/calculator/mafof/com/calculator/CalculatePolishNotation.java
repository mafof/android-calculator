package calculator.mafof.com.calculator;

import android.widget.TextView;
import java.util.ArrayList;

public class CalculatePolishNotation extends HandlerGUI {
    private ArrayList<Number> stackNumber;
    private ArrayList<String> stackMathOperator;

    CalculatePolishNotation(TextView preResult, TextView result) {
        super(preResult, result);
        stackNumber = new ArrayList<>();
        stackMathOperator = new ArrayList<>();
    }

    public void addNumber(Number number) {
        stackNumber.add(number);
        updatePreResult(number.toString());
    }
    public void addMathOperation(String operation) {
        stackMathOperator.add(operation);
        updatePreResult(operation);
    }
}
