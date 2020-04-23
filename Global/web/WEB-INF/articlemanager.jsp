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
                <li><a href="/Global/userManager">Users</a></li>
                <li><a href="/Global/commentManager">Comments</a></li>
            </ul>
        </div>
        <div>
            <form method="post" action="connexion">
                <fieldset>
                    <legend>Edit Article</legend>
                    <label for="title">Title <span class="requis">*</span></label>
                    <input type="text" id="title" name="title" value="<c:out value="${article.title}"/>" size="20" maxlength="100" />
                    <span class="erreur">${form.erreurs['title']}</span>
                    <br />
                    <label for="content">Content <span class="requis">*</span></label>
                    <input type="text" id="content" name="content" value="" size="200" maxlength="5000" />
                    <span class="erreur">${form.erreurs['content']}</span>
                    <br />
                    <input type="submit" value="Create" class="sansLabel" />
                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                    <%-- Vérification de la présence d'un objet utilisateur en session --%>
                    <c:if test="${!empty sessionScope.sessionUtilisateur}">
                        <%-- Si l'utilisateur existe en session, alors on affiche son pseudo --%>
                        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.nom}</p>
                    </c:if>
                </fieldset>
            </form>
        </div>
        <jsp:include page="/WEB-INF/footer.jsp" />
        <!-- /c:if
        c:otherwise
            <p>You're not logged in as an administrator.</p>
        /c:otherwise
        -->
    </body>
</html>
