package models;

public class LoanSchedule {
    private double capital; //wielkosc kredytu
    private double interest; //oprocentowanie
    private double fixedFee; // oplata stala
    private int installmentCount; //rata
    private double finalInstallment; //calkowita kwota raty

    public LoanSchedule(double capital, double interest, double fixedFee, int installmentCount, double finalInstallment) {
        this.capital = capital;
        this.interest = interest;
        this.fixedFee = fixedFee;
        this.installmentCount = installmentCount;
        this.finalInstallment = finalInstallment;
    }

    public double getCapital() {
        return capital;
    }

    public double getInterest() {
        return interest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public double getFinalInstallment() {
        return finalInstallment;
    }
}
