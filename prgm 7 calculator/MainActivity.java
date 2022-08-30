package ben.app.markcalculator;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calculate(View view) {
        int num1, num2, res = 0;
        EditText result = (EditText) findViewById(R.id.result);

        EditText n1 = (EditText) findViewById(R.id.first);
        num1 = Integer.parseInt(n1.getText().toString());
        EditText n2 = (EditText) findViewById(R.id.second);
        num2 = Integer.parseInt(n2.getText().toString());
        if (view.getId() == R.id.add) {
            res = num1 + num2;
            result.setText(res + "");

        }

        if (view.getId() == R.id.sub) {
            res = num1 - num2;
            result.setText(res + "");


        }

        if (view.getId() == R.id.mul) {
            res = num1 * num2;
            result.setText(res + "");


        }

        if (view.getId() == R.id.div) {
            res = num1 / num2;
            result.setText(res + "");
        }

        if (view.getId() == R.id.clr){
            result.setText(" ");


        }


    }

}