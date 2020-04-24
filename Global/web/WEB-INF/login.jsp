<%-- 
    Document   : login
    Author     : June
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Login</title>
        <style><jsp:include page="/styles/global.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <form action="<c:url value="/login/" />" method="POST">
            Name: <input name="name" type="text" value="${requestScope.user.name}" />
            <span>${requestScope.form.errors.name}</span><br>
            Mail: <input name="email" type="text" value="${requestScope.user.email}" />
            <span>${requestScope.form.errors.email}</span><br>
            <input type="submit" value="Send" />
        </form>
        <p>
        <c:if test="${!empty sessionScope.session}"><p>Vous êtes connecté</p></c:if>
        <c:if test="${sessionScope.admin}"><p>Vous êtes admin</p></c:if>
        </p>
    <jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
