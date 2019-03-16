package servlets;


import Utils.PDFCreator;
import com.itextpdf.text.DocumentException;
import loanTypes.Constance;
import loanTypes.Descend;
import loanTypes.Loan;
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

            if (request.getParameter("loanType").equals("const")) {
                response.getWriter().println("Raty stale");

                int value = Integer.parseInt(request.getParameter("loanValue"));
                int installment = Integer.parseInt(request.getParameter("loanInstallment"));
                double interest = Double.parseDouble(request.getParameter("loanInterest"));
                double fixedFee = Double.parseDouble(request.getParameter("fixedFee"));

                Loan loan = new Constance(value, installment, interest, fixedFee);
                ArrayList<LoanSchedule> loanTableArrayList = loan.calculateInstallment();

                request.setAttribute("loanTableArrayList", loanTableArrayList);
                request.getRequestDispatcher("LoanSchedule.jsp").forward(request, response);
            }
            else if (request.getParameter("loanType").equals("desc")) {
                response.getWriter().println("Raty malejace");

                int value = Integer.parseInt(request.getParameter("loanValue"));
                int installment = Integer.parseInt(request.getParameter("loanInstallment"));
                double interest = Double.parseDouble(request.getParameter("loanInterest"));
                double fixedFee = Double.parseDouble(request.getParameter("fixedFee"));


                Loan loan = new Descend(value, installment, interest, fixedFee);
                ArrayList<LoanSchedule> loanTableArrayList = loan.calculateInstallment();

                request.setAttribute("loanTableArrayList", loanTableArrayList);
                request.getRequestDispatcher("LoanSchedule.jsp").forward(request, response);
            }
            else
                response.sendRedirect("/");
        }
}

