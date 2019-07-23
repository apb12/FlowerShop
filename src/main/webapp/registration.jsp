<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
        <script src="http://code.jquery.com/jquery-2.2.4.js"
                type="text/javascript"></script>

    </head>
<style>
  body { background: url(images/img3.jpg); }
</style>
<body>
    <h1 align=center>ВХОД</h1>
    <hr>
    <form action="RegistrServlet" method="post">
        <hr>
	    <p align=center>Введите свое имя:</p>
		<p align=center><input type="text" name = "name" size="30px"></p>
		<br>
		<p align=center>Введите свой электронный адресс:</p>
		<p align=center><input type="text" name = "email" size="30px"></p>
		<br>
		<p align=center>Придумайте логин:</p>
		<p align=center><input type="text" id="login" name="login" value="${login}" size="30px"></p>
		<br>
		<p align=center>Придумайте пароль:</p>
		<p align=center><input type="password" name = "password" size="30px"></p>
		<br>
		<hr>
		<p align=center><input type="submit" name = "regButton" value="регистрация"></p>
	</form>
	  <script>
                     	                $(document).ready(function() {
                                         $('#login').blur(function() {
                                         console.log('сработка события onchange');
                                         $.ajax({
                                             url: 'rest/validate_login/'+$('#login').val(),

                                             success: function(data) {
                                                 if (data == 'true'){
                                                 alert('Такой логин существует,придумайте новый')
                                                 }
                                               }
                                            });
                                        });
                                     });
                                 </script>
</body>
</html>
