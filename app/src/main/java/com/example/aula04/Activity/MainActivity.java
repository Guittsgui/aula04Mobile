package com.example.aula04.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aula04.Model.Loan;
import com.example.aula04.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout loanValue, loanFees, monthQuantity, entryValue;
    Button calculateLoanDatasButton;
    Integer qtdMonths;
    Double value, fee, eValue;




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

                if(verifyEmptyFields()){
                    Toast.makeText(getApplicationContext(), "Preencha todos os Campos", Toast.LENGTH_LONG).show();
                    return;
                }

                fillVariables();

                if(eValue >= value){
                    Toast.makeText(getApplicationContext(), "Entrada não pode ser maior/igual que o Empréstimo", Toast.LENGTH_LONG).show();
                    return;
                }

                Loan newLoan = createLoan();
                clearFields();
                Intent intent = new Intent(getApplicationContext(), LoanResult.class);
                intent.putExtra("loan", newLoan);
                startActivity(intent);

            }
        };
    }

    private void clearFields() {
        loanFees.getEditText().setText("");
        loanValue.getEditText().setText("");
        monthQuantity.getEditText().setText("");
        entryValue.getEditText().setText("");

    }

    private void fillVariables() {
        qtdMonths = Integer.parseInt(monthQuantity.getEditText().getText().toString());
        value = Double.parseDouble(loanValue.getEditText().getText().toString());
        fee = Double.parseDouble(loanFees.getEditText().getText().toString());
        if(entryValue.getEditText().getText().toString().equals("")){
            eValue = 0.0;
        }else{
            eValue = Double.parseDouble(entryValue.getEditText().getText().toString());
        }
    }


    private Loan createLoan() {
        Loan loan = new Loan(qtdMonths, value, fee, eValue );
        return loan;
    }

    private boolean hasEntryValue() {
        if (loanValue.getEditText().getText().toString().equals("")){
            return false;
        }
        return true;
    }

    private boolean verifyEmptyFields() {
        if (loanValue.getEditText().getText().toString().equals("") ||
                loanFees.getEditText().getText().toString().equals("") ||
                monthQuantity.getEditText().getText().toString().equals("")){
            return true;
        }
        return false;
    }

    private void binding() {
        loanValue = findViewById(R.id.loanValueTIL);
        loanFees = findViewById(R.id.loanFeeTIL);
        monthQuantity = findViewById(R.id.numberOfMonthsTIL);
        entryValue = findViewById(R.id.entryValueTIL);
        calculateLoanDatasButton = findViewById(R.id.loanCalculateButton);
    }
}