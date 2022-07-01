package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// LER OS DOIS PARAMETROS
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando " + login);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		if (usuario != null) {
			System.out.println("Usuario existe");
			// pegar a sessao que foi criada no navegador
			HttpSession sessao = request.getSession();
			// mandar o login para a próxima requisição
			sessao.setAttribute("usuarioLogado", usuario);
			// volta para o navegador
			return "redirect:entrada?acao=ListarEmpresas";
		} else {
			// volta para o navegador
			return "redirect:entrada?acao=LoginForm";
		}
	}

}