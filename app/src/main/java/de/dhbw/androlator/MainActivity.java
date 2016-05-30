package de.dhbw.androlator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        EditText tfNo1 = (EditText) findViewById(R.id.tfNo1);
        EditText tfNo2 = (EditText) findViewById(R.id.tfNo2);
        Spinner spinnerOperator = (Spinner) findViewById(R.id.spinnerOperator);
        TextView lblResult = (TextView) findViewById(R.id.lblResult);

        try {
            double no1 = Double.valueOf(tfNo1.getText().toString());
            double no2 = Double.valueOf(tfNo2.getText().toString());
            String op = spinnerOperator.getSelectedItem().toString();
            double result;
            switch (op) {
                case "+":
                    result = no1 + no2;
                    break;
                case "-":
                    result = no1 - no2;
                    break;
                case "*":
                    result = no1 * no2;
                    break;
                case "/":
                    result = no1 / no2;
                    break;
                default:
                    result = 0;
            }
            tfNo1.setText("");
            tfNo2.setText("");
            lblResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
