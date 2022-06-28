package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A ANOTA��O FOI COMENTADA POIS ESTA CONFIGURADO NO ARQUIVO XML
//oi
//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	// N�O TEM MAIN POIS QUEM DA NEW � O SERVLETCONTAINER O TONCAT NO CASO
	// TONCAT MIDDLEWARE � UM INTERMEDI�RIO ENTRE A REUISI��O HTTP E A NOSSA CLASSE.
	public OiMundoServlet() {
		// O TOMCAT QUE CRIA ESTE CONSTRUTOR
		// O TONCAR S� CRIA A INSTANCIA QUANDO ALGUEM CHAMA
		// SERVLET � UM SINGLETON POIS S� TEM UMA INSTANCIA DESSA CLASSE AQUI
		// SERVLET VIVE PARA SEMPRE S� UMA INSTANCIA PARA TODAS REQUISI��ES HTTP
		System.out.println("Criando OiMundoServlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, parabens vc escreveu o primeiro servlets.");
		out.println("</body>");
		out.println("</html>");

		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
