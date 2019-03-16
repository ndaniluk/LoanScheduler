package servlets;

import validation.InputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/Validator")
public class ValidatorServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.sendRedirect("/");
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Enumeration<String> parameterNamesEnum = request.getParameterNames();
            List<String> parameterNames = Collections.list(parameterNamesEnum);

            InputValidator validator = new InputValidator();
            if(validator.validate(request, parameterNames)) {
                for (String parameterName : parameterNames)
                    request.setAttribute(parameterName, request.getParameter(parameterName));
                request.getRequestDispatcher("/LoanSchedule").forward(request, response);
            }
            else
                response.sendRedirect("/");
        }

}
