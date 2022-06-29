package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

//N�o usado mais pois foi para pacore acao
//@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveEmpresaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BUSCAR O PARAMETRO
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		// CONECTAR AO BANCO
		Banco banco = new Banco();
		// REMOVER
		banco.removeEmpresa(id);

		// REDIRECIONAR PARA O CONTROLLER DE LISTAR
		response.sendRedirect("listaEmpresas");
	}

}
