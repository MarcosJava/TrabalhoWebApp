<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"><!-- LINK PARA O BOOTSTRAP -->
	<link rel="stylesheet" type="text/css" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
	<script src="../bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container">


	

      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">Entre !</h2>
        
        ${msgErro}
        
        <label for="inputEmail" class="sr-only">Email:</label>
        <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email">
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" id="inputPassword" class="form-control" name="senha" placeholder="Senha">
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      </form>

    </div> <!-- /container -->

</body>
</html>