<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Do you want to delete book: ${book.title}? </p>
<a href="/book">No</a>
<a href="/book/delete/${book.id}?accept=true">Yes</a>
</body>
</html>
