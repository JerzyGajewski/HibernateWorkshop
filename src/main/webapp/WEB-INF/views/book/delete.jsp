<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Choose book to delete</h1>
<ul>
    <c:forEach items="${books}" var="book">
        <li>
            <h4>${book.title}</h4>
            <p>author: ${book.author}</p>
            <p>isbn: ${book.isbn}</p>

            <a href="/book/delete/${book.id}">Delete</a>
        </li>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/"><button type="button">Back</button></a>

</ul>
</body>
</html>