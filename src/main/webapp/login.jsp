<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  body { background: url(images/img2.jpg); }
</style>
<body>
    <hr>
    <h1 align=center>ВХОД</h1>
    <hr>
    <br><br>
    <form action="LoginServlet" method="post">
        <hr>
	    <p align=center>Введите свой логин:</p>
		<p align=center><input type="text" name = "login" size="30px"></p>
		<br>
		<p align=center>Введите свой пароль:</p>
		<p align=center><input type="password" name = "password" size="30px"></p>
		<br>
		<hr>
		<p align=center><input type="submit" name = "loginButton" value="войти"></p>
	</form>
	<br><br>
	<form action="registration.jsp">
	<p align=center><button>регистрация</button></p>
	</form>
</body>
</html>
