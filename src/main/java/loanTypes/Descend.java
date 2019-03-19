package loanTypes;

import calculations.Rounder;
import models.LoanSchedule;

import java.util.ArrayList;

public class Descend extends Loan {

    public Descend(int value, int installmentCount, double interest, double fixedFee) {
        super(value, installmentCount, interest, fixedFee);
        this.fixedFee /= this.installmentCount;
    }

    public ArrayList<LoanSchedule> calculateInstallment() {
        double capital = this.value / this.installmentCount;
        capital = Rounder.round(capital);
        ArrayList<LoanSchedule> allInstallments = new ArrayList<LoanSchedule>();

        for (int i = 0; i < this.installmentCount; i++) {
            double interestFee = (this.value - i * capital) * (this.interest / 100) / 12;
            interestFee = Rounder.round(interestFee);

            double finalInstallment = capital + interestFee + this.fixedFee;
            finalInstallment = Rounder.round(finalInstallment);

            LoanSchedule loanTable = new LoanSchedule(capital, interestFee, Rounder.round(this.fixedFee), this.installmentCount, finalInstallment);
            allInstallments.add(loanTable);
        }


        return allInstallments;
    }


}
