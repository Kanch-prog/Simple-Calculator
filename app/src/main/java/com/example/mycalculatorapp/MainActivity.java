package com.example.mycalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables for the UI elements
    private EditText editText1;
    private EditText editText2;
    private TextView resultTextView;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements by finding them by their IDs
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        resultTextView = findViewById(R.id.resultTextView);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        // Set onClickListener for the Add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+'); // Call calculate method with addition operator
            }
        });

        // Set onClickListener for the Subtract button
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });
        
        // Set onClickListener for the Multiply button
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        // Set onClickListener for the Divide button
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    // Method to perform the calculation based on the operator provided
    private void calculate(char operator) {
        String input1 = editText1.getText().toString(); // Get the text from the first input field
        String input2 = editText2.getText().toString(); // Get the text from the first input field

        // Check if either input field is empty
        if (input1.isEmpty() || input2.isEmpty()) {
            resultTextView.setText(R.string.error_message);
            return;
        }

        // Parse the input strings to double values
        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result;

        // Perform the calculation based on the operator
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // Check if the denominator is zero
                if (num2 == 0) {
                    resultTextView.setText(R.string.division_by_zero_error);
                    return; 
                }
                result = num1 / num2;
                break;
            default:
                resultTextView.setText(R.string.error_message); // Display a general error message
                return; // Exit the method early
        }

        // Display the result in the resultTextView
        resultTextView.setText(String.valueOf(result));
    }
}

