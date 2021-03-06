<%-- 
    Document   : usermanager
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Admin - Users</title>
        <style><jsp:include page="/styles/global.css" /></style>
        <style><jsp:include page="/styles/admin.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <div class="body_content">
            <h1>Administration Panel: User Manager</h1>
            <c:if test="${sessionScope.admin}">
                <div id="adminTab">
                    <ul>
                        <li><a href="/Global/articleManager">Articles</a></li>
                        <li><a href="/Global/commentManager">Comments</a></li>
                    </ul>
                </div>
            </c:if>
            <c:if test="${!sessionScope.admin}">
                <p>Really, you have no power here.</p>
            </c:if>
        </div>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <!-- /c:if
        c:otherwise
            <p>You're not logged in as an administrator.</p>
        /c:otherwise
        -->
    </body>
</html>
