<html>
<head>Login Page </head>
<body>Welcome and put your login
<form th:action="@{/login}"   method="post">
Name: <input type="text" name="name">
Password: <input type="password" name="password">
<input type="submit">
</form>


</body>

</html>
