<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Books library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<%
    List<Book> books = (ArrayList<Book>) request.getAttribute("books");
    Integer amount = (Integer) request.getAttribute("amount");

    for (Object book : books) {
        Book libraryBook = (Book) book;
        out.println(libraryBook);
    }

    out.println("Amount of books in library - " + amount);
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>

