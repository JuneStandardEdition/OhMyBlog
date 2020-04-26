<%-- 
    Document   : register
    Author     : June
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OhMyBlog - Register</title>
        <style><jsp:include page="/styles/global.css" /></style>
    </head>
    <body>
        <jsp:include page="/WEB-INF/header.jsp" />
        <h1>Register</h1>
        <form method="POST" action="register">
            <fieldset>
                <legend>Register Form</legend>

                <label for="nom">Username</label>
                <input type="text" id="name" name="name" value="${requestScope.user.name}" size="20" maxlength="20" />              
                <span class='erreur'>${requestScope.form.errors.name}</span>
                <br />

                <label for="email">Email</label>
                <input type="text" id="email" name="email" value="${requestScope.user.email}" size="20" maxlength="60" />
                <span class='erreur'>${requestScope.form.errors.email}</span>
                <br />

                <label for="motdepasse">Password</label>
                <input type="password" id="pwd" name="pwd" value="" size="20" maxlength="20" />                
                <span class='erreur'>${requestScope.form.errors.password}</span>
                <br />

                <label for="confirmation">Confirm</label>
                <input type="password" id="conf" name="conf" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Register" />

                <p class="${empty form.errors ? "success" : "error"}">${form.result}</p>
            </fieldset>
        </form>
        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
