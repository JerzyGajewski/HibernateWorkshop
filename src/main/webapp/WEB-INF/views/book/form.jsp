<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Book ${book.id == null ? "add" : "edit"} form</h1>

<form:form method="post" action="/book/save" modelAttribute="books">
    <form:hidden path="id"/>
    <form:errors path="*"/>

    <section>
        <form:input path="title" placeholder="Title"/>
        <form:errors path="title"/>

        <section>
            <form:input path="author" placeholder="Author"/>
            <form:errors path="author"/>
        </section>

        <section>
            <form:input path="isbn" placeholder="Isbn Nr"/>
            <form:errors path="isbn"/>
        </section>

        <button type="submit">Save</button>
    </section>
    <a href="${pageContext.request.contextPath}/"><button type="button">Back</button></a>

</form:form>


</body>
</html>
