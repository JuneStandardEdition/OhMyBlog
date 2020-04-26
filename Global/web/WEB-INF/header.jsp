<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div id="header_image_div">
        <a href="<c:url value="/home"/>"><img id="header_img" src="<c:url value="/imgs/OhMyBlog.png" />" alt="Header"></a>
    </div>
    <div id="header_list_div">
        <ol id="header_list_ol">
            <li class="header_li"><a href="<c:url value="/home"/>">Home</a></li>
            <li class="header_li"><a href="<c:url value="/article"/>">Articles</a></li>
            <c:if test="${empty sessionScope}">
            <li class="header_li"><a href="<c:url value="/login"/>">Login</a></li>
            <li class="header_li"><a href="<c:url value="/register"/>">Register</a></li>
            </c:if>
            <c:if test="${sessionScope.admin}">
            <li class="header_li"><a href="<c:url value="/admin"/>">Admin</a></li>
            </c:if>
            <c:if test="${!empty sessionScope}">
            <li class="header_li"><a id="logout" href="<c:url value="/logout"/>">Logout</a></li>
            </c:if>
        </ol>
    </div>
</header>