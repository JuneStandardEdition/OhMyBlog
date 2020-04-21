<%-- 
    Document   : footer
    Created on : 17 avr. 2020, 15:58:46
    Author     : Herbert <herbert.caffarel@ldnr.fr>
--%>

<footer>
    <%-- Vérification de la présence d'un objet utilisateur en session --%>
    <c:choose>
        <c:when test="${!empty sessionScope.sessionUtilisateur}">
            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
            Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}
        </c:when>
        <c:otherwise>
            Vous n'êtes pas connecté. Souhaitez-vous vous <a href="<c:url value="/connexion" />">connecter</a> ?
        </c:otherwise>
    </c:choose>
</footer>