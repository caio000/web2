package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorDAO;
import dao.BookDAO;
import models.Author;
import models.Book;

/**
 * Servlet implementation class BookController
 */
@WebServlet(urlPatterns= {"/","/book"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookDAO dao = new BookDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Book> books = new ArrayList<>(dao.getAll());
		request.setAttribute("books", books);
		request.setAttribute("test", "mensagem de teste");
		
		if (Boolean.parseBoolean(request.getParameter("delete"))) {
			try {
				long id = Long.parseLong(request.getParameter("id"));
				bookDelete(id, request, response);				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else {
			RequestDispatcher rd = request.getRequestDispatcher("book/list.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book(request.getParameter("book_name"));
		Author author = new Author();
		System.out.println("nome autor " + request.getParameter("book_author_name"));
		author.setName(request.getParameter("book_author_name"));
		System.out.println(book);
		author.add(book);
		book.setAuthor(author);
		
		AuthorDAO authorDAO = new AuthorDAO();
		
		authorDAO.persist(author);
		dao.persist(book);
		
		response.sendRedirect("book");
	}
	
	/**
	 * Função para deletar um livro do sistema.
	 * @param id
	 * @throws IOException 
	 */
	protected void bookDelete (long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Book book = this.dao.getById(id);
		this.dao.delete(book);
		response.sendRedirect("book");
	}

}
