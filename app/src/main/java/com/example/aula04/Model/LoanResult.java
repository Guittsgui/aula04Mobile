package com.example.aula04.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aula04.R;

public class LoanResult extends AppCompatActivity {
    
    TextView loanValueField, loanFeeField, loanMonthsField, loanEntryField;
    TextView loanFullValueWithFeeField, justFeeField , discountingEntry, monthlyPrice;
    Button finishButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_result);
        
        binding();
        Loan mainLoan = (Loan) getIntent().getSerializableExtra("loan");


        loanValueField.setText("Você solicitou um empréstimo de: R$" + mainLoan.getLoanValue() );
        loanFeeField.setText("Taxa de juros contratada de: " + mainLoan.getLoanFees() + "%");
        loanMonthsField.setText("Pagamento será realizado em " + mainLoan.getQuantityOfMonths()+ " meses");
        loanEntryField.setText("Entrada realizada no valor de: R$" + mainLoan.getEntryValue());

        loanFullValueWithFeeField.setText("Total c/ juros a ser pago: R$" + mainLoan.getFullLoanValueWithFees());
        justFeeField.setText("Valor apenas dos Juros: R$" + mainLoan.getFeeValue());
        discountingEntry.setText("Descontando o valor da entrade de: R$ " + mainLoan.getEntryValue() +
                ". Ficará faltando um valor de: R$" + mainLoan.getTotalWithoutEntry());
        monthlyPrice.setText(" Esse valor será pago em : " + mainLoan.getQuantityOfMonths() +
                " parcelas no valor de R$" + mainLoan.getMonthlyPriceToPay());

        finishButton.setOnClickListener(finishView());
    }

    private View.OnClickListener finishView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
    }

    private void binding() {
        loanValueField = findViewById(R.id.loanValueTV);
        loanFeeField = findViewById(R.id.loanFeeTV);
        loanMonthsField = findViewById(R.id.monthsQtTV);
        loanEntryField = findViewById(R.id.entryValueTV);

        loanFullValueWithFeeField = findViewById(R.id.totalWithFeeTV);
        justFeeField = findViewById(R.id.justFeeValueTV);
        discountingEntry = findViewById(R.id.discountingEntryTV);
        monthlyPrice = findViewById(R.id.monthlyPriceTV);

        finishButton = findViewById(R.id.finishButton);

    }
}