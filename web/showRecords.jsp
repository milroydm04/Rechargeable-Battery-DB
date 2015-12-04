<%-- 
    Document   : displayRecords
    Created on : Nov 20, 2015, 5:19:26 PM
    Author     : Dylan Lozo
--%>

<%@page import="java.util.List, model.Batt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Video Game Library</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
    </head>
    <body>
        <h1><a href="home.html">Rechargeable Battery Database</a></h1>
        <h2>Rechargeable Battery Database</h2>
        <%
            List<Batt> mydata = (List<Batt>) request.getAttribute("mydata");
            out.println("<table>");
            for (Batt book : mydata) {
                out.println(book.inHTMLRowFormat());
            }
            out.println("</table>");
        %>
    </body>
</html>
