<%-- 
    Document   : header
    Created on : 17 avr. 2020, 15:58:22
    Author     : Herbert <herbert.caffarel@ldnr.fr>
--%>

<header>
    <nav>
        <ul>
            <li class="button"><a href="<c:url value="/" />">Accueil</a></li>
            <c:choose>
                <c:when test="${empty sessionScope.sessionUtilisateur}" >
                    <li class="button"><a href="<c:url value="/inscription" />">Inscription</a></li>
                    <li class="button"><a href="<c:url value="/connexion" />">Connexion</a></li>
                    </c:when>
                    <c:otherwise>
                    <li class="button"><a href="<c:url value="/deconnexion" />">Déconnexion</a></li>
                    </c:otherwise>
                </c:choose>
        </ul>
    </nav>
</header>
