<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<link rel="stylesheet" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

function getdata(){

	var prime = document.getElementById('numberN').value;
	var threads = document.getElementById('numberT').value;
	
	if(prime!='' && threads!='' ){
		
			$.ajax({
				url: '/JobAssignment/api/prime/'+prime+'?threadSize='+threads,
				method: 'get',
				dataType: 'xml',
				cache: false,
				success: function(data){
					var x = data.getElementsByTagName("primeNumber");
					var y = data.getElementsByTagName("totalPrimes")[0].childNodes[0].nodeValue;
					var tbl = "<ul class='list-group'>"
					
					for(i=0; i<x.length; i++){
					tbl += "<li class='list-group-item'>" + x[i].childNodes[0].nodeValue + "</li>"	
					}
					tbl += "</ul><p>Total Primes generated are " +y
					document.getElementById('datafill').innerHTML = tbl;
				},
				async: true
			});
	}
	return false;

}
</script>
</head>
<body>
<div id="weather"></div>
	<div class="container-fluid">
		<h2>Enter Details for getting Prime Numbers</h2>
		<form class="form-group">
			<div class="form-group">
				<label for="email">Enter Number:</label> 
				<input type="number" id='numberN' class="form-control" required name='numberN'
					placeholder="Enter Number">
			</div>
			<div class="form-group">
				<label for="threads">Enter Number of Threads:</label> 
				<input type="number" class="form-control" required id='numberT' name='numberT'
					placeholder="Enter Number of Threads">
			</div>

			<button onclick="getdata();return false;" class="btn btn-default">Display Primes</button>
		</form>
	</div>
<div class="container-fluid">
<h2>Prime Number Generation</h2>
<div id="datafill">
</div>
</div>
</body>
</html>