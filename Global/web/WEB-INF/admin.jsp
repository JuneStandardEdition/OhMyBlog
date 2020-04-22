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
        <style><jsp:include page="/styles/admin.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h1>Administration Panel</h1>
        <!-- c:if (User.getProperty(isAdmin) == true) -->
        <nav id="adminMenu">
            <ul>
                <li class="button"><a href="<c:url value="/usrmgr" />">Users</a></li>
                <li class="button"><a href="<c:url value="/articlemgr" />">Articles</a></li>
                <li class="button"><a href="<c:url value="/commentmgr" />">Comments</a></li>
            </ul>
        </nav>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <!-- /c:if
        c:otherwise
            <p>You're not logged in as an administrator.</p>
        /c:otherwise
        -->
    </body>
</html>
