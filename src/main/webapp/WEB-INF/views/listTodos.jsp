<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">

   <title>List Todos Page</title>
   	</head>
   	<body>
   		<div class="container">
   			<h1>Your Todos</h1>
   			<table class="table">
   				<thead>
   					<tr>
   						<th>id</th>
   						<th>Description</th>
   						<th>Target Date</th>
   						<th>Is Done?</th>
   					</tr>
   				</thead>
   				<tbody>
   					<c:forEach items="${todos}" var="todo">
   						<tr>
   							<td>${todo.id}</td>
   							<td>${todo.description}</td>
   							<td>${todo.targetDate}</td>
   							<td>${todo.done}</td>
   						</tr>
   					</c:forEach>
   				</tbody>
   			</table>
   			<a href="addTodos" class="btn btn-success"> Add Todos</a>
   		</div>
        <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>

</form>
</body>
</html>
