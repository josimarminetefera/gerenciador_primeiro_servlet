package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//Esta class não é um servlet e serve para passar por dentro do interceptador.
public class ListarEmpresas implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=LoginForm";
		}
		System.out.println("---------ListarEmpresas");
		Banco banco = new Banco();
		// PEGA A LISTA DE EMPRESAS
		List<Empresa> lista = banco.getEmpresas();

		// CRIA O PARAMETRO PARA ENVIAR PARA A JSP
		request.setAttribute("empresas", lista);

		return "forward:listaEmpresas.jsp";
	}
}
