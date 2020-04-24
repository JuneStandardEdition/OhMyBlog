<%-- 
    Document   : admin
    Author     : June
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Admin</title>
        <style><jsp:include page="/styles/global.css" /></style>
        <style><jsp:include page="/styles/admin.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h1>Administration Panel</h1>
        <!-- c:if (User.getProperty(isAdmin) && ...(isConnected) == true) -->
        <div id="adminTab">
            <ul>
                <li><a href="userManager">Users</a></li>
                <li><a href="articleManager">Articles</a></li>
                <li><a href="commentManager">Comments</a></li>
            </ul>
        </div>
        <c:forEach items="${requestScope.users}" var="user">
            <span><p>name: ${user.name} | email: ${user.email}</p></span>
        </c:forEach>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <!-- /c:if
        c:otherwise
            <p>You're not logged in as an administrator.</p>
        /c:otherwise
        -->
    </body>
</html>
