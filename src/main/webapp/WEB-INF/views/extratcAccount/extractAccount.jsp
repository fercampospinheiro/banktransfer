<%-- 
    Document   : extractAccount
    Created on : 07/05/2016, 14:50:21
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extrato da Conta</title>
    </head>
    <body>
        <h1>Extrato bancário</h1>
        Conta : <br>
        <table>
            <th>Deposito</th>
            <th>Data</th>
            <th>Saque</th>
            <th>Data</th>
            <th>Tranferencia<th
            <th>Para conta</th>
            <th>Saldo Atual</th>
            <c:forEach items="${extratcts}" var="extratc">
            <tr>
                <td>${extract.valueDeposit}</td>
                <td>${extract.dateDeposit}</td>
                <td>${extract.withdrarw}</td>
                <td>${extract.dateWithDraw}</td>
                <td>${extract.valueTransfer}</td>
                <td>${extract.numberAccount}</td>
                <td>${extract.balance}</td>
            </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
