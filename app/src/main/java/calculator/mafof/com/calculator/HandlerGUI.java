package calculator.mafof.com.calculator;

import android.widget.TextView;

public class HandlerGUI {
    private TextView preResult;
    private TextView result;
    protected String preResultText = "";

    public HandlerGUI(TextView preResult, TextView result) {
        this.preResult = preResult;
        this.result = result;
    }

    @Deprecated
    public void updatePreResult(String operator) {
        preResultText = preResult.getText().toString();
        preResult.setText(preResultText + operator);
    }

    @Deprecated
    public boolean isMaxLength() { return preResultText.length() == 39; }
}
