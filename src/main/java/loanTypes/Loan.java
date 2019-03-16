package loanTypes;

import models.LoanSchedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Loan {

    protected int value; //wielkosc kredytu
    protected int installmentCount; //rata
    protected double interest; //oprocentowanie
    protected double fixedFee; // oplata stala

    public Loan(int value, int installmentCount, double interest, double fixedFee) {
        this.value = value;
        this.installmentCount = installmentCount;
        this.interest = interest;
        this.fixedFee = fixedFee / 100 * this.value;
    }

    public abstract ArrayList<LoanSchedule> calculateInstallment();


}


