package calculator.mafof.com.calculator.polishwrite;

import java.util.ArrayList;

public class Calc extends StacksPriority {

    private ArrayList<String> stackResult; // Стек результата
    private ArrayList<String> stackTehas;  // Стек техаса
    private ArrayList<String> stackEquation;

    protected void calculate(ArrayList<String> stackEquation) {
        stackTehas = new ArrayList<>();
        stackResult = new ArrayList<>();
        this.stackEquation = stackEquation;
        stackTehas.add("BREAK");
        //prioritet(stackEquation.);
    }

    private void prioritet(String element) {

    }

    private void action(int type) {}

    private void next() {}
}
