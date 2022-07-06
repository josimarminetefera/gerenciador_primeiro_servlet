package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

// monitora tempo de execução de cada requisição feita
//se usar anotação qyuem toma conta do filter é o 
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
		// manda a cadeia da requisição para frente
		// no caso é o proximo filter
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();

		System.out.println("Tempo: " + (depois - antes) + " / " + acao);
		
	}

}
