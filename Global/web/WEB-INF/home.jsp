<%--
    Document   : home
    Author     : June
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Home</title>
        <style><jsp:include page="/styles/global.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <div class="body_content">
            <h1>Home</h1>
            <c:forEach items="${ articles }" var="atl" end="9">
                <h2>${atl.title}</h2>
                <p>${atl.content}</p>
                <p>Score: ${atl.score}</p><br>
            </c:forEach>
        </div>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
