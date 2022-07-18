<%@page isELIgnored="false"%>
<%@taglib prefix="command" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

 <title>Customer Details</title>
</head>
<body>
<h2>Add Customer</h2>
<div class="container">
<form method="POST" class="col-6" modelAttribute="customer" action="save">
    <input class="form-control" type="text" placeholder="Movie name" name="customerName"/>
    <input class="form-control"  type="text" placeholder="Movie length(minutes)" name="email"/>
    <button  class="btn btn-primary" type="submit">Add Customer</button>
</form>
</div>
<form method="GET" action="customers" >
<button  class="btn btn-primary" type="submit">View Customers</button>
</form>
<div class="container">
<h2>Customer List</h2>
<table class = "table table-striped">
<thead>
    <tr>
    <th>Customer Id</th>
    <th>Customer Name<th>
    <th>Customer Email</th>
    </tr>
</thead>
<tbody>
<command:forEach items="${customers}" var="customer">
<tr>
    <td>${customer.customerId}<td>
    <td>${customer.customerName}</td>
    <td>${customer.email}</td>

</tr>
   </command:forEach>
</tbody>
</table>

</div>
</body>
</html>