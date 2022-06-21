package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Teste de Nome");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Teste de Segundo Nome");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

}
