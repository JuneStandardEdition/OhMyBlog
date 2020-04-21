<%-- 
    Document   : inscription
    Created on : 16 avr. 2020, 15:49:54
    Author     : Herbert <herbert.caffarel@ldnr.fr>
--%>

<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link rel="stylesheet" href="<c:url value="/inc/global.css" />">
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="<c:out value="${user.email}" />" size="20" maxlength="60" />
                <span class='erreur'>${form.erreurs.email}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />                
                <span class='erreur'>${form.erreurs.motdepasse}</span>
                <br />

                <label for="confirmation">Confirmation <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${user.nom}" />" size="20" maxlength="20" />              
                <span class='erreur'>${form.erreurs.nom}</span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />

                <p>Les champs marqués d'un <span class="requis">*</span> sont obligatoires.</p>
                <p class="${empty form.erreurs ? "succes" : "erreur"}">${form.resultat}</p>
            </fieldset>
        </form>
            <%@include file="/WEB-INF/footer.jsp" %>
    </body>
</html>
