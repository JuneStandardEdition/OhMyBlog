<%-- 
    Document   : footer
    Created on : 17 avr. 2020, 15:58:46
    Author     : Herbert <herbert.caffarel@ldnr.fr>
--%>

<footer>
    <%-- V�rification de la pr�sence d'un objet utilisateur en session --%>
    <c:choose>
        <c:when test="${!empty sessionScope.sessionUtilisateur}">
            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
            Vous �tes connect�(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}
        </c:when>
        <c:otherwise>
            Vous n'�tes pas connect�. Souhaitez-vous vous <a href="<c:url value="/connexion" />">connecter</a> ?
        </c:otherwise>
    </c:choose>
</footer>