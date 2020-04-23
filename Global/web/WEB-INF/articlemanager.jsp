<%-- 
    Document   : articlemanager
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Admin - Articles</title>
        <style><jsp:include page="/styles/global.css" /></style>
        <style><jsp:include page="/styles/admin.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h1>Administration Panel: Article Manager</h1>
        <!-- c:if (User.getProperty(isAdmin) == true) -->
        <div id="adminTab">
            <ul>
                <li><a href="/WEB-INF/usermanager.jsp">Users</a></li>
                <li><a href="/WEB-INF/articlemanager.jsp">Articles</a></li>
                <li><a href="/WEB-INF/commentmanager.jsp">Comments</a></li>
            </ul>
        </div>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <!-- /c:if
        c:otherwise
            <p>You're not logged in as an administrator.</p>
        /c:otherwise
        -->
    </body>
</html>
