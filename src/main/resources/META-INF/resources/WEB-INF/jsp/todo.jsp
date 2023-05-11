<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <title>List Todos Page</title>
    </head>
    <body>
    <div class="container">
        <div>Welcome ${name}</div>
        <hr>
        <h1>Enter Todos Details</h1>
        <form method="POST">
            Description <input type="text" name="description" required = "required"/>
            <input type="submit" class="btn btn-success">
        </form>
    </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>