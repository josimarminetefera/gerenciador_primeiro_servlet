package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoverEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("---------RemoverEmpresa");
		// BUSCAR O PARAMETRO
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		// CONECTAR AO BANCO
		Banco banco = new Banco();
		// REMOVER
		banco.removeEmpresa(id);

		// REDIRECIONAR PARA O CONTROLLER DE LISTAR
		response.sendRedirect("entrada?acao=ListarEmpresas");
	}

}
