package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

// monitora tempo de execu��o de cada requisi��o feita
//se usar anota��o qyuem toma conta do filter � o 
// @WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("-------------------------------novo-------------------------------");
		System.out.println("MonitoramentoFilter");

		long antes = System.currentTimeMillis();

		String acao = request.getParameter("acao");

		// executar a acao
		// manda a cadeia da requisi��o para frente
		// no caso � o proximo filter
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();

		System.out.println("Tempo: " + (depois - antes) + " / " + acao);
		
	}

}
