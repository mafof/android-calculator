package calculator.mafof.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CalculatePolishNotation calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new CalculatePolishNotation((TextView) findViewById(R.id.preResult),(TextView) findViewById(R.id.result));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_0:         calc.addNumber(0);                      break;
            case R.id.button_1:         calc.addNumber(1);                      break;
            case R.id.button_2:         calc.addNumber(2);                      break;
            case R.id.button_3:         calc.addNumber(3);                      break;
            case R.id.button_4:         calc.addNumber(4);                      break;
            case R.id.button_5:         calc.addNumber(5);                      break;
            case R.id.button_6:         calc.addNumber(6);                      break;
            case R.id.button_7:         calc.addNumber(7);                      break;
            case R.id.button_8:         calc.addNumber(8);                      break;
            case R.id.button_9:         calc.addNumber(9);                      break;
            case R.id.button_plus:      calc.addMathOperation("+");             break;
            case R.id.button_minus:     calc.addMathOperation("-");             break;
            case R.id.button_divide:    calc.addMathOperation("/");             break;
            case R.id.button_multiply:  calc.addMathOperation("*");             break;
            case R.id.button_result:    MyLog.d("click button result");  break;
            case R.id.button_clear:     MyLog.d("click button clear");   break;
            case R.id.button_backspace: MyLog.d("click button backspace");break;
            case R.id.button_plusMinus: MyLog.d("click button plusMinus");break;
            case R.id.button_comma:     MyLog.d("click button comma");   break;
        }
    }
}
