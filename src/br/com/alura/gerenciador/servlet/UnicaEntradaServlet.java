package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlterarEmpresa;
import br.com.alura.gerenciador.acao.ListarEmpresas;
import br.com.alura.gerenciador.acao.MostrarEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoverEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UnicaEntradaServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("ListarEmpresas")) {
			//http://localhost:8080/gerenciador/entrada?acao=ListarEmpresas
			System.out.println("ListarEmpresas");
			ListarEmpresas ac = new ListarEmpresas();
			ac.executa(request,response);
		}else if (acao.equals("RemoverEmpresa")) {
			System.out.println("ListarEmpresas");
			RemoverEmpresa actoin = new RemoverEmpresa();
			actoin.executa(request,response);
		}else if (acao.equals("MostrarEmpresa")) {
			System.out.println("MostrarEmpresa");
			MostrarEmpresa actoin = new MostrarEmpresa();
			actoin.executa(request,response);
		}else if (acao.equals("AlterarEmpresa")) {
			System.out.println("AlterarEmpresa");
			AlterarEmpresa actoin = new AlterarEmpresa();
			actoin.executa(request,response);
		}else if (acao.equals("NovaEmpresa")) {
			//http://localhost:8080/gerenciador/formNovaEmpresa.jsp
			System.out.println("NovaEmpresa");
			NovaEmpresa actoin = new NovaEmpresa();
			actoin.executa(request,response);
		}
	}

}
