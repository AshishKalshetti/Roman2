package com.ashish.roman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editTextNumber.getText().toString().trim();
                if (!input.isEmpty()) {
                    int decimalNumber = Integer.parseInt(input);
                    String romanNumeral = convertToRoman(decimalNumber);
                    textViewResult.setText(romanNumeral);
                } else {
                    textViewResult.setText("Enter a valid number");
                }
            }
        });
        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No action needed
            }

            @Override
            public void afterTextChanged(Editable s) {
                textViewResult.setText("");
            }
        });
    }
    private String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            return "Invalid Number";
        }

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number / 1000] +
                hundreds[(number % 1000) / 100] +
                tens[(number % 100) / 10] +
                units[number % 10];
    }
    private int adjustAlpha(int color, float alpha) {
        int alphaValue = Math.round(alpha * 255);
        return (alphaValue << 24) | (color & 0x00FFFFFF);
    }
}