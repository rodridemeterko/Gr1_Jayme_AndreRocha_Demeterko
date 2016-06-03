<%-- 
    Document   : inicial
    Created on : 16/05/2016, 14:22:08
    Author     : demeterko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
</head>
<body>
        <h1>Construção...</h1>
        <form action="ServletBlue" method="get">
            <input type="hidden" id="user_form" name="user_id" value="${param['user_id']}"/>
            <input type="submit" value="Gerador de Mapas">   
        </form>
        
</body>
</html>
    