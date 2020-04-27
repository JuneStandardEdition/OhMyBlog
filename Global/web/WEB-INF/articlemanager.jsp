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
        <div class="body_content">
            <h1>Administration Panel: Article Manager</h1>
            <c:if test="${sessionScope.admin}">
                <div id="adminTab">
                    <ul>
                        <li><a href="/Global/userManager">Users</a></li>
                        <li><a href="/Global/commentManager">Comments</a></li>
                    </ul>
                </div>
                <div id="form_div">
                    <form method="post" action="articleManager">
                        <fieldset>
                            <legend>Edit Article</legend>
                            <label for="title">Title</label>
                            <input type="text" id="title" name="title" value="<c:out value="${article.title}"/>" size="20" maxlength="100" placeholder="Title of the article..." />
                            <span class="erreur">${form.errors['title']}</span>
                            <br />
                            <label for="content">Content</label>
                            <input type="textarea" id="content" name="content" value="" size="200" maxlength="5000" placeholder="Type your article..." />
                            <span class="erreur">${form.errors['content']}</span>
                            <br />
                            <input type="submit" value="Send" class="sansLabel" />
                            <p class="${empty form.errors ? 'success' : 'failed'}">${form.result}</p>
                            <%-- Vérification de la présence d'un objet utilisateur en session --%>
                            <c:if test="${!empty sessionScope.sessionUser}">
                                <%-- Si l'utilisateur existe en session, alors on affiche son pseudo --%>
                                <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.nom}</p>
                            </c:if>
                        </fieldset>
                    </form>
                </div>
            </c:if>
            <c:if test="${!sessionScope.admin}">
                <p>All your administrator privileges are belong to us.</p>
            </c:if>
        </div>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
