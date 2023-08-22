package com.example.aula04.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aula04.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout loanValue, loanFees, monthQuantity, entryValue;

    Button calculateLoanDatasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        binding();

        calculateLoanDatasButton.setOnClickListener(handleCalculateLoan());
    }

    private View.OnClickListener handleCalculateLoan() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    private void binding() {
        loanValue = findViewById(R.id.loanValueTIL);
        loanFees = findViewById(R.id.loanFeeTIL);
        monthQuantity = findViewById(R.id.numberOfMonthsTIL);
        entryValue = findViewById(R.id.entryValueTIL);
        calculateLoanDatasButton = findViewById(R.id.loanCalculateButton);
    }
}