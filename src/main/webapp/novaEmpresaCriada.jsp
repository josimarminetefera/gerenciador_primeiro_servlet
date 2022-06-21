<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//scriptlet
	String empresa_teste = "Teste";
	System.out.println(empresa_teste);
	String empresaParametro = (String)request.getAttribute("empresa");
%>

<html>
<body>
	Formas de mostrar parametros em uma jsp
	<br>
	Empresa <%out.println(empresa_teste);%> cadastrada.
	<br> 
	Empresa <%=empresa_teste%> cadastrada.
	<br> 
	Empresa <%=empresaParametro%> cadastrada.
	<br> 
	Empresa ${1+1} cadastrada.
	<br> 
	Empresa ${empresa} cadastrada.
	<br>
	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	<br>
	<c:if test="${empty empresa}">
		Nenhuma empresa cadastrada!
	</c:if>
</body>
</html>
