<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <c:if test="${empty sessionScope}">
        <p>You're not logged in. Head to <a id="footer_link" href="<c:url value="/login" />">this link</a> to log in.</p>
    </c:if>
    <c:if test="${!empty sessionScope}">
        <p>Logged in as <span id="user_name"><c:out value="${sessionScope.name}" /></span>. <a id="footer_link" href="<c:url value="/logout" />">Log out?</a></p>
    </c:if>
</footer>