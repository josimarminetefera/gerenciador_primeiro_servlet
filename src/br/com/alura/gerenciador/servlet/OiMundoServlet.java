package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A ANOTAÇÃO FOI COMENTADA POIS ESTA CONFIGURADO NO ARQUIVO XML
//oi
//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	// NÃO TEM MAIN POIS QUEM DA NEW É O SERVLETCONTAINER O TONCAT NO CASO
	// TONCAT MIDDLEWARE É UM INTERMEDIÁRIO ENTRE A REUISIÇÃO HTTP E A NOSSA CLASSE.
	public OiMundoServlet() {
		// O TOMCAT QUE CRIA ESTE CONSTRUTOR
		// O TONCAR SÓ CRIA A INSTANCIA QUANDO ALGUEM CHAMA
		// SERVLET É UM SINGLETON POIS SÓ TEM UMA INSTANCIA DESSA CLASSE AQUI
		// SERVLET VIVE PARA SEMPRE SÓ UMA INSTANCIA PARA TODAS REQUISIÇÕES HTTP
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
