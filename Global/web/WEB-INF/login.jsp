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
        <div class="body_content">
            <h1>Login</h1>
            <form action="<c:url value="login" />" method="POST">
                Username: <input name="name" type="text" value="${requestScope.user.name}" />
                <span>${requestScope.form.errors.name}</span><br>
                Password: <input name="password" type="password" value="${requestScope.user.password}" />
                <span>${requestScope.form.errors.password}</span><br>
                <input type="submit" value="Login" />
            </form>
            <p>
            <c:if test="${!empty sessionScope.session}"><p>Connected!</p></c:if>
            <c:if test="${sessionScope.admin}"><p>Adminly connected!</p></c:if>
            </p>
        </div>
    <jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
