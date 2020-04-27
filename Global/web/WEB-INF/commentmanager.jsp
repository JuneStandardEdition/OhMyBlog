<%-- 
    Document   : commentmanager
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Admin - Comments</title>
        <style><jsp:include page="/styles/global.css" /></style>
        <style><jsp:include page="/styles/admin.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <div class="body_content">
            <h1>Administration Panel: Comment Manager</h1>
            <c:if test="${sessionScope.admin}">
                <div id="adminTab">
                    <ul>
                        <li><a href="/Global/userManager">Users</a></li>
                        <li><a href="/Global/articleManager">Articles</a></li>
                    </ul>
                </div>
                <div id="cmtmngr">
                    <!-- c:if il y a des commentaires signalés -->
                    <!-- c:foreach via liste des commentaires signalés -->
                    <div>
                        <form>
                            <span>Author: <!-- user.name --></span>
                            <br>
                            <span>Comment: <!-- comment.content --></span>
                            <br>
                            <input type="button" id="delete" name="delete" value="Delete">
                            <input type="button" id="dismiss" name="dismiss" value="Dismiss">
                        </form>
                    </div>
                    <!-- /c:foreach -->
                </c:if>
                <c:if test="${!sessionScope.admin}">
                    <p>Watcha doin here mae?</p>
                </c:if>
            </div>
        </div>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <!-- /c:if
        c:otherwise
            <p>You're not logged in as an administrator.</p>
        /c:otherwise
        -->
    </body>
</html>
