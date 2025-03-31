
	<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>

		<div class="container" >
			<h1>Enter Todo Details</h1>
			  <form:form method="post" modelAttribute="todo">

			  <fieldset class="mb-3">
			        <form:label path="description">Description</form:label>
			        <form:input type="text" path="description" required ="required"/>
			        <form:errors path="description" cssClass="text-danger"/>
			  </fieldset>
			  <fieldset class="mb-3">
              		<form:label path="targetDate">Target Date</form:label>
              	    <form:input type="text" path="targetDate" required ="required"/>
              		<form:errors path="targetDate" cssClass="text-danger"/>
              </fieldset>

			               <input type="submit" class="btn btn-success"/>
			               <form:input type="hidden" path="id"/>
			               <form:input type="hidden" path="done"/>
			  </form:form>

		</div>
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
		<%@ include file="common/footer.jspf" %>

		<script type="text/javascript">
        		$('#targetDate').datepicker({
        		    format: 'yyyy-mm-dd'
        		});
        		</script>
