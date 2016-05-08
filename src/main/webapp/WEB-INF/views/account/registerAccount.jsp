<%-- 
    Document   : registerAccount
    Created on : 07/05/2016, 12:29:29
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadstro de conta bancária</title>
    </head>
    <body>
        <h1>Cadastro de conta bancária</h1>
        <form action="save" method="post">
            Conta : <input type="text" name="numberAccount"/>  <br>
            Banco : <select name="codeBank">
                        <option value="1">Banco do Brasil</option>
                        <option value="2">Caixa Economica</option> 
                    </select>
            <br>
            nome do cliente : <input type="text" name="nameCliente"/>
            <br>
            Data de nascimento: <input type="date" name="birthDateCliente" pattern="dd/MM/yyyy"/>
            <br>
            <button type="submit">Enviar</button>
        </form>
        
        
    </body>
</html>
