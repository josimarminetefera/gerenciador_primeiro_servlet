package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovaEmpresaServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);

		// RequestDispatcher rd =
		// request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		// request.setAttribute("empresa", empresa.getNome());
		// rd.forward(request, response);

		// chamar o JPS, isso aqui é um redirecionamento no lado do servidor
		// RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		// request.setAttribute("empresa", empresa.getNome());
		// rd.forward(request, response);

		// redirecionamento do lado do cliente
		response.sendRedirect("listaEmpresas");
	}

	// http://localhost:8080/gerenciador/novaEmpresa?nome=Alura&teste=Teste
	// este metodo aceita ger e post
	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("Cadastrando nova empresa"); String nomeEmpresa =
	 * req.getParameter("nome"); PrintWriter out = resp.getWriter();
	 * out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" +
	 * "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Insert title here</title>\r\n"
	 * + "</head>\r\n" + "<body>\r\n" + " Empresa " + nomeEmpresa +
	 * " cadastrada com sucesso\r\n" + "</body>\r\n" + "</html>"); }
	 */
}
