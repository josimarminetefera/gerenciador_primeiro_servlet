package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

// Cada requisição entra aqui antes 
// Para definir a ordem de execução de um filter tem que configurar no web xml.
// este será o ultimo filtro na cadeia
//@WebFilter(filterName = "entrada", urlPatterns = { "/entrada" })
public class ControladorFilter extends HttpFilter implements Filter {

	public ControladorFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String acao = request.getParameter("acao");
		String nomeClass = "br.com.alura.gerenciador.acao." + acao;

		String nome = null;
		try {
			Class<?> classe = Class.forName(nomeClass);
			Acao ac = (Acao) classe.newInstance();
			nome = ac.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] endereco = nome.split(":");
		if (endereco[0].contains("forward")) {
			// DISPARA PARA A JSP
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + endereco[1]);
			rd.forward(request, response);
		} else {
			// REDIRECIONAR PARA O CONTROLLER DE LISTAR
			response.sendRedirect(endereco[1]);
		}

		/*
		 * http://localhost:8080/gerenciador/entrada?acao=ListarEmpresas
		 * http://localhost:8080/gerenciador/entrada?acao=LoginForm String nome = null;
		 * if (acao.equals("ListarEmpresas")) { //
		 * http://localhost:8080/gerenciador/entrada?acao=ListarEmpresas
		 * System.out.println("ListarEmpresas"); ListarEmpresas ac = new
		 * ListarEmpresas(); nome = ac.executa(request, response); } else if
		 * (acao.equals("RemoverEmpresa")) { System.out.println("RemoverEmpresa");
		 * RemoverEmpresa actoin = new RemoverEmpresa(); nome = actoin.executa(request,
		 * response); } else if (acao.equals("MostrarEmpresa")) {
		 * System.out.println("MostrarEmpresa"); MostrarEmpresa actoin = new
		 * MostrarEmpresa(); nome = actoin.executa(request, response); } else if
		 * (acao.equals("AlterarEmpresa")) { System.out.println("AlterarEmpresa");
		 * AlterarEmpresa actoin = new AlterarEmpresa(); nome = actoin.executa(request,
		 * response); } else if (acao.equals("NovaEmpresa")) { //
		 * http://localhost:8080/gerenciador/formNovaEmpresa.jsp
		 * System.out.println("NovaEmpresa"); NovaEmpresa actoin = new NovaEmpresa();
		 * nome = actoin.executa(request, response); } else if
		 * (acao.equals("NovaEmpresaForm")) { //
		 * http://localhost:8080/gerenciador/entrada?acao=NovaEmpresaForm
		 * System.out.println("NovaEmpresaForm"); NovaEmpresaForm actoin = new
		 * NovaEmpresaForm(); nome = actoin.executa(request, response); }
		 */

		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
