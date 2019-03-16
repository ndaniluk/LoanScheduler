package validation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class InputValidator {
    public boolean validate(HttpServletRequest request, List<String> parameterNames) {

        boolean flag = true;


        for (int i = 0; i < parameterNames.size(); i++) {
            if (request.getParameter(parameterNames.get(i)) == null) {
                flag = false;
                break;
            }

            if (!isEmpty(request, parameterNames.get(i))) {
                flag = false;
                break;
            }

            if(!isDigit(request, parameterNames.get(i))){
                if(parameterNames.get(i).equals("loanType") || parameterNames.get(i).equals("submit"))
                    continue;
                flag = false;
                break;
            }
        }

        return flag;
    }

    private boolean isEmpty(HttpServletRequest request, String parameter){
        if(request.getParameter(parameter).equals(""))
            return false;
        return true;
    }
    private boolean isDigit(HttpServletRequest request, String parameter){
        try{
            Double.parseDouble(request.getParameter(parameter));
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
