package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

	//http://localhost:8080/gerenciador/entrada?acao=LoginForm
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("LoginForm");
    	//JOGA A GSP PELO CONTROLLER PARA O USUÁRIO
        return "forward:formLogin.jsp";
    }

}
