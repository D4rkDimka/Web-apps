<%@ page import="java.util.List" %>
<%@ page import="com.tms.prudnik.dto.Book" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Books Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table table-striped table-info">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Автор</th>
                <th scope="col">Кол-во страниц</th>
                <th scope="col">Действие</th>
            </tr>
            </thead>
            <tbody>
            <form action="/JSTL/bookslibrary" method="post">
            <c:forEach var="book" items="${books}" varStatus="loop">
                <tr>
                    <th scope="row">${loop.count}</th>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.amountOfPages}</td>
                    <td> <button type="submit" class="btn btn-info">Удалить</button></td>
                    <input type="hidden" name="bookname" value="${book.name}">
                </tr>
            </c:forEach>
            </form>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"crossorigin="anonymous"></script>
</body>
</html>
