package calculator.mafof.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GUI calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new GUI((TextView) findViewById(R.id.preResult), (TextView) findViewById(R.id.result));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_0:            calc.add("0"); break;
            case R.id.button_1:            calc.add("1"); break;
            case R.id.button_2:            calc.add("2"); break;
            case R.id.button_3:            calc.add("3"); break;
            case R.id.button_4:            calc.add("4"); break;
            case R.id.button_5:            calc.add("5"); break;
            case R.id.button_6:            calc.add("6"); break;
            case R.id.button_7:            calc.add("7"); break;
            case R.id.button_8:            calc.add("8"); break;
            case R.id.button_9:            calc.add("9"); break;
            case R.id.button_plus:         calc.add("+"); break;
            case R.id.button_minus:        calc.add("-"); break;
            case R.id.button_divide:       calc.add("/"); break;
            case R.id.button_multiply:     calc.add("*"); break;
            case R.id.button_comma:        calc.add("."); break;
            case R.id.button_bracketLeft:  calc.add("("); break;
            case R.id.button_bracketRight: calc.add(")"); break;
            case R.id.button_plusMinus: MyLog.d("click button plusMinus"); break;
            case R.id.button_result:    MyLog.d("click button result"); break;
            case R.id.button_clear:        calc.clear(); break;
            case R.id.button_backspace:    calc.backspace(); break;
        }
    }
}
