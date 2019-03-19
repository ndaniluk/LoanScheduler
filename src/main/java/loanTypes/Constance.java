package loanTypes;

import calculations.Rounder;
import models.LoanSchedule;

import java.util.ArrayList;

public class Constance extends Loan {

    public Constance(int value, int installmentCount, double interest, double fixedFee) {
        super(value, installmentCount, interest, fixedFee);
    }

    @Override
    public ArrayList<LoanSchedule> calculateInstallment() {
        double calculatedInterest = interest / 100;
        double capital = this.value + this.fixedFee;
        double finalInstallment = capital * Math.pow((1 + calculatedInterest / 12), this.installmentCount) * ((1 + calculatedInterest / 12 - 1) / (Math.pow((1 + calculatedInterest / 12), this.installmentCount) - 1));
        finalInstallment = Rounder.round(finalInstallment);
        this.fixedFee = Rounder.round(this.fixedFee);

        ArrayList<LoanSchedule> loanSchedule = new ArrayList<LoanSchedule>();
        for (int i = 0; i < this.installmentCount; i++) {
            loanSchedule.add(new LoanSchedule(capital, this.interest, this.fixedFee, this.installmentCount, finalInstallment));
        }

        return loanSchedule;
    }
}
