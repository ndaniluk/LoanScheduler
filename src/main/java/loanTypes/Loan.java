package loanTypes;

import models.Input;
import models.LoanSchedule;

import java.util.ArrayList;

public abstract class Loan {

    protected int value;
    protected int installmentCount;
    protected double interest;
    protected double fixedFee;

    public Loan(int value, int installmentCount, double interest, double fixedFee) {
        this.value = value;
        this.installmentCount = installmentCount;
        this.interest = interest;
        this.fixedFee = fixedFee / 100 * this.value;
    }

    public abstract ArrayList<LoanSchedule> calculateInstallment();
}


