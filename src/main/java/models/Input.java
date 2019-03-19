package models;

public class Input {
    private int value;
    private int installment;
    private double interest;
    private double fixedFee;
    private String loanType;

    public Input(int value, int installment, double interest, double fixedFee, String loanType) {
        this.value = value;
        this.installment = installment;
        this.interest = interest;
        this.fixedFee = fixedFee;
        this.loanType = loanType;
    }

    public int getValue() {
        return value;
    }

    public int getInstallment() {
        return installment;
    }

    public double getInterest() {
        return interest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public String getLoanType() {
        return loanType;
    }
}
