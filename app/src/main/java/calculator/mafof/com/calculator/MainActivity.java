package calculator.mafof.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_0:         MyLog.d("click button 0");
            case R.id.button_1:         MyLog.d("click button 1");
            case R.id.button_2:         MyLog.d("click button 2");
            case R.id.button_3:         MyLog.d("click button 3");
            case R.id.button_4:         MyLog.d("click button 4");
            case R.id.button_5:         MyLog.d("click button 5");
            case R.id.button_6:         MyLog.d("click button 6");
            case R.id.button_7:         MyLog.d("click button 7");
            case R.id.button_8:         MyLog.d("click button 8");
            case R.id.button_9:         MyLog.d("click button 9");
            case R.id.button_plus:      MyLog.d("click button plus");
            case R.id.button_minus:     MyLog.d("click button minus");
            case R.id.button_divide:    MyLog.d("click button divide");
            case R.id.button_multiply:  MyLog.d("click button multiply");
            case R.id.button_result:    MyLog.d("click button result");
            case R.id.button_clear:     MyLog.d("click button clear");
            case R.id.button_backspace: MyLog.d("click button backspace");
            case R.id.button_plusMinus: MyLog.d("click button plusMinus");
            case R.id.button_comma:     MyLog.d("click button comma");
        }
    }
}
