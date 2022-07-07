package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Cada requisição entra aqui antes 
// Para definir a ordem de execução de um filter tem que configurar no web xml.
// @WebFilter(filterName = "entrada", urlPatterns = { "/entrada" })
public class AutorizacaoFilter implements Filter {

	public AutorizacaoFilter() {
		super();
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String acao = request.getParameter("acao");

		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoNaoProtegida = !(acao.equals("Login") || acao.equals("LoginForm"));
		if (acaoNaoProtegida && usuarioNaoEstaLogado) {
			System.out.println("------------- NAO AUTORIZADO");
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		} else {
			System.out.println("------------- AUTORIZADO");
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
