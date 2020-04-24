<%-- 
    Document   : article
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Article</title>
    </head>
    <body>
        <h1>${requestScope.article.titre}</h1>
        <p>${requestScope.article.contenu}</p>
        <p>score=${requestScope.article.score}</p>
    </body>
</html>
