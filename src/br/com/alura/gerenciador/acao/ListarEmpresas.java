package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//Esta class n�o � um servlet e serve para passar por dentro do interceptador.
public class ListarEmpresas {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---------ListarEmpresas");
		Banco banco = new Banco();
		// PEGA A LISTA DE EMPRESAS
		List<Empresa> lista = banco.getEmpresas();

		// CRIA O PARAMETRO PARA ENVIAR PARA A JSP
		request.setAttribute("empresas", lista);

		// DISPARA PARA A JSP
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}
}
