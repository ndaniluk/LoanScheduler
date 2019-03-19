package servlets;


import calculations.InputParser;
import loanTypes.Constance;
import loanTypes.Descend;
import loanTypes.Loan;
import models.Input;
import models.LoanSchedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LoanSchedule")
public class LoanScheduleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Input input = castInput(request);
        Loan loan;

        if (request.getParameter("loanType").equals("const")) {
            response.getWriter().println("Raty stale");

            loan = new Constance(input.getValue(), input.getInstallment(), input.getInterest(), input.getFixedFee());

        } else if (request.getParameter("loanType").equals("desc")) {
            response.getWriter().println("Raty malejace");

            loan = new Descend(input.getValue(), input.getInstallment(), input.getInterest(), input.getFixedFee());

        } else
            loan = null;

        ArrayList<LoanSchedule> loanTableArrayList;
        if (loan != null) {
            loanTableArrayList = loan.calculateInstallment();
            request.setAttribute("loanTableArrayList", loanTableArrayList);
            request.getRequestDispatcher("LoanSchedule.jsp").forward(request, response);
        } else
            response.sendRedirect("/");
    }

    private Input castInput(HttpServletRequest request) {
        String value = request.getParameter("loanValue");
        String installment = request.getParameter("loanInstallment");
        String interest = request.getParameter("loanInterest");
        String fixedFee = request.getParameter("fixedFee");
        String loanType = request.getParameter("loanType");

        Input input = InputParser.parseInput(value, installment, interest, fixedFee, loanType);
        return input;
    }
}

