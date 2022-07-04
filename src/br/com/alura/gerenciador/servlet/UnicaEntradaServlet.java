package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UnicaEntradaServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String nomeClass = "br.com.alura.gerenciador.acao." + acao;

		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoNaoProtegida = !(acao.equals("Login") || acao.equals("LoginForm"));
		if (acaoNaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

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

}
