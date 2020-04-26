<%-- 
    Document   : article
    Author     : Solène
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Article</title>
        <style><jsp:include page="/styles/global.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h1>${requestScope.article.title}</h1>
        <p>${requestScope.article.content}</p>
        <p>score=${requestScope.article.score}</p>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
