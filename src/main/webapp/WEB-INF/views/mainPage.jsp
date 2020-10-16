<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<nav>
    <h1>Book Library</h1>
    <ul>
        <label>Show book list</label>
        <li><a href="${pageContext.request.contextPath}/book"><button type="button">List</button></a></li>
        <label>Add new book</label>
        <li><a href="${pageContext.request.contextPath}/book/new"><button type="button">Add</button></a></li>
        <label>Remove book from list</label>
        <li><a href="${pageContext.request.contextPath}/book/delete"><button type="button">Remove</button></a></li>
    </ul>
</nav>
</body>
</html>
