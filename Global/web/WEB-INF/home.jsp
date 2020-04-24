<%--
    Document   : home
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Home</title>
        <style><jsp:include page="/styles/global.css" /></style>
    </head>
    <body>
        <h1>TODO: Home page</h1>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <h2>${requestScope.article1.titre}</h2>
        <p>${requestScope.article1.contenu}</p>
        <p>score=${requestScope.article1.score}</p><br><br>

        <h2>${requestScope.article2.titre}</h2>
        <p>${requestScope.article2.contenu}</p>
        <p>score=${requestScope.article2.score}</p><br><br>

        <h2>${requestScope.article3.titre}</h2>
        <p>${requestScope.article3.contenu}</p>
        <p>score=${requestScope.article3.score}</p>
        <jsp:include page="/WEB-INF/footer.jsp" />

    </body>
</html>
