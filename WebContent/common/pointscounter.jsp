<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link
	href="<%=request.getContextPath()%>/assets/counter/jquery.counter-analog.css"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/assets/counter/jquery.counter-analog2.css"
	media="screen" rel="stylesheet" type="text/css" />
	<link
	href="<%=request.getContextPath()%>/assets/counter/jquery.counter-analog3.css"
	media="screen" rel="stylesheet" type="text/css" />

 
<script src="<%=request.getContextPath()%>/assets/counter/jquery.counter.js"
	type="text/javascript"></script>

		<script type="text/javascript"> 
		$(window).load(function() {
		
	        	
	        	 $('#custom').counter({
			            initial: ${sessionScope.Student.points-1},
			            direction: 'up',
			            interval: '1',
			            format: '999999',
			            stop: ${sessionScope.Student.points}
			        });
	        
		
	});	
		
	</script>

</head>
<body>

	
	<span class="my-font badge badge-default" style="font-size: large;color: black;"><b>My Points:</b>
	<span id="custom" class="counter counter-analog"></span></span>
				
       
        



</body>
</html>
