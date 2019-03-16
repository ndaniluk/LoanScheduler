<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form method="post" action="Validator">
    <p>Wnioskowana kwota kredytu</p>
    <input type="number" step="0.01" value="200000" name="loanValue" required> PLN
    <br>

    <p>Ilosc rat</p>
    <input type="number" value="30" name="loanInstallment" required>
    <br>

    <p>Oprocentowanie</p>
    <input type="number" step="0.01" name="loanInterest" required> %
    <br>

    <p>Oplata stala</p>
    <input type="number" step="0.01" name="fixedFee" required> %
    <br>

    <p>Rodzaj rat</p>
    <input type="radio" id="const"
           name="loanType" value="const" checked>
    <label for="const">Stale</label>

    <input type="radio" id="desc"
           name="loanType" value="desc">
    <label for="desc">Malejace</label>
    <br><br>

    <input type="submit" value="Oblicz" name="submit">
</form>
</body>
</html>