package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");

		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");

		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("josi");
		u1.setSenha("12345");

		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	// No java voce não pode interar e alterar o valor ao mesmo tempo.
	// Abaixo está a forma certo voce intera primeiro e depois percorre fazendo a
	// alteração que quer
	public void removeEmpresa(Integer id) {

		// CRIA UM ITERADOR PARA DEPOIS PERCORRER
		Iterator<Empresa> it = lista.iterator();

		// PERCORRE CADA ITEM
		while (it.hasNext()) {
			Empresa emp = it.next();
			// ENCONTRADO O ID AGORA REMOVE
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
