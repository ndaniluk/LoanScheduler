package calculations;

import models.Input;

public class InputParser {
    public static Input parseInput(String value, String installment, String interest, String fixedFee, String loanType){
        int valueParsed = Integer.parseInt(value);
        int installmentParsed = Integer.parseInt(installment);
        double interestParsed = Double.parseDouble(interest);
        double fixedFeeParsed = Double.parseDouble(fixedFee);
        
        Input input = new Input(valueParsed, installmentParsed, interestParsed, fixedFeeParsed, loanType);
        return input;
    }
}
