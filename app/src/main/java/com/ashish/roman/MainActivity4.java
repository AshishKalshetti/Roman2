package com.ashish.roman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void onConvertButtonClicked(View view) {
        EditText romanEditText = findViewById(R.id.romanEditText);
        String romanNumeral = romanEditText.getText().toString().toUpperCase();

        int decimalValue = romanToDecimal(romanNumeral);

        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Decimal Value: " + decimalValue);
    }

    private int romanToDecimal(String roman) {

                if (roman == null || roman.isEmpty()) {
                    throw new IllegalArgumentException("Invalid Roman numeral");
                }

                int[] decimalValues = new int[26]; // We only need to store values for letters I to Z (up to 1000)
                decimalValues['I' - 'A'] = 1;
                decimalValues['V' - 'A'] = 5;
                decimalValues['X' - 'A'] = 10;
                decimalValues['L' - 'A'] = 50;
                decimalValues['C' - 'A'] = 100;
                decimalValues['D' - 'A'] = 500;
                decimalValues['M' - 'A'] = 1000;

                int decimalValue = 0;
                int prevValue = 0;

                for (int i = roman.length() - 1; i >= 0; i--) {
                    char numeral = roman.charAt(i);
                    int currentValue = decimalValues[numeral - 'A'];

                    if (currentValue >= prevValue) {
                        decimalValue += currentValue;
                    } else {
                        decimalValue -= currentValue;
                    }

                    prevValue = currentValue;
                }

                return decimalValue;
    }
}
