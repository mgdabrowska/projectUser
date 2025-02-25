<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Welcome on the List Page</title>
</head>
<body>
<form >
    <div> Welcome ${name}</div>

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

</form>
</body>
</html>
