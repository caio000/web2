<%@page import="dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Book"%>
<%@page import="com.sun.javafx.print.PrintHelper.PrintAccessor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teste JPA</title>
</head>
<body>

	<h1>Olá mundo!</h1>
	
	<div>
		 <p>${test}</p>
	</div>
	
	<form action="book" method="post">
		<fieldset>
			<legend>Cadastro de livros</legend>
			<input type="text" name="book_name" placeholder="nome do livro"/>
			
			<input type="text" name="book_author_name" placeholder="Fulano de tal"/>
			
			<button type="submit">Cadastrar</button>
		</fieldset>
	</form>

	<table border="1" width="100%">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<% 
				ArrayList<Book> books = new ArrayList<Book>(new BookDAO().getAll());
			
				for (int i = 0; i < books.size(); i++) {
					String row = "<tr>";
					row += "<td>" + books.get(i).getId() + "</td>";
					row += "<td>" + books.get(i).getName() + "</td>";
					row += "<td><a href=\"book?delete=true&&id="+ books.get(i).getId() +"\">Deletar</a></td>";
					row += "</tr>";
					out.println(row);
				}
			%>
		</tbody>
	</table>

</body>
</html>