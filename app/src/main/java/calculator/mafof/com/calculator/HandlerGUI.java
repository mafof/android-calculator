package calculator.mafof.com.calculator;

import android.widget.TextView;

public class HandlerGUI {
    private TextView preResult;
    private TextView result;

    public HandlerGUI(TextView preResult, TextView result) {
        this.preResult = preResult;
        this.result = result;
    }

    public void updatePreResult(String operator) {
        String preResultText = (String) preResult.getText();
        preResult.setText(preResultText + " " + operator);
    }
}
