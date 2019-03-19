<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="PDFCreator.PDFCreator" %>
<%@page import="models.LoanSchedule" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table>
    <tr>
        <th>Nr raty</th>
        <th>Kwota kapitalu</th>
        <th>Kwota odsetek</th>
        <th>Oplaty stale</th>
        <th>Calkowita kwota raty</th>
    </tr>
    <% ArrayList<LoanSchedule> loans = (ArrayList<LoanSchedule>) request.getAttribute("loanTableArrayList");
        for (int i = 0; i < loans.size(); i++) {
            out.print("<tr>");
            out.print("<td>" + (i + 1) + "</td>");
            out.print("<td>" + loans.get(i).getCapital() + " zl</td>");
            out.print("<td>" + loans.get(i).getInterest() + " zl</td>");
            out.print("<td>" + loans.get(i).getFixedFee() + " zl</td>");
            out.print("<td>" + loans.get(i).getFinalInstallment() + " zl</td>");
            out.print("</tr>");
        }

        PDFCreator pdfCreator = new PDFCreator();
        pdfCreator.create(loans);
    %>
</table>
</body>
</html>