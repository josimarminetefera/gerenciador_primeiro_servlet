package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession sessao = request.getSession();
		// remover o usuário logado
		// sessao.removeAttribute("usuarioLogado");
		// remove todas sessoes do usuário
		sessao.invalidate();

		return "redirect:entrada?acao=LoginForm";
	}

}
