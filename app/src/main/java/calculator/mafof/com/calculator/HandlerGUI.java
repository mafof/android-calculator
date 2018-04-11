package calculator.mafof.com.calculator;

import android.widget.TextView;

import java.util.ArrayList;

public class HandlerGUI {
    private TextView preResult;
    private TextView result;
    protected StringBuilder preResultText;

    public HandlerGUI(TextView preResult, TextView result) {
        this.preResult = preResult;
        this.result = result;
    }

    protected void drawPreResult(ArrayList<String> stackEquation) {
        preResultText = new StringBuilder();
        for(String el: stackEquation)
            preResultText.append(el);
        preResult.setText(preResultText);
    }

    @Deprecated
    public boolean isMaxLength() { return preResultText.length() == 39; }
}
