package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servilet com o nome de /oi
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// web pode retornar binário ou html(texto)
		// binário é com o getOutputStream
		// html ou texto com o getWriter
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ " Oi Mundo, você escreveu o primeiro servlet.\r\n" + "</body>\r\n" + "</html>");
		System.out.println("OiMundoServlet foi chamado.");
	}
}
