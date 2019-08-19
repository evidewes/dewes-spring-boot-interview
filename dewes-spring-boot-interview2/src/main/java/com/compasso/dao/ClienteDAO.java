package com.compasso.dao;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.compasso.model.Cliente;
import com.compasso.model.Sexos;

public class ClienteDAO {

	private static ClienteDAO singleInstance = null;
	private List<Cliente> clientes;

	private ClienteDAO() {
		this.clientes = new LinkedList<>();

		try {
			this.populateClientes();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ClienteDAO getInstance() {
		if (singleInstance == null) {
			singleInstance = new ClienteDAO();
		}

		return singleInstance;
	}

	public List<Cliente> getAll() {
		return clientes;
	}

	public Cliente getClienteById(String id) {
		return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst().get();
	}

	public Cliente getClienteByNome(String nome) {
		return clientes.stream().filter(cliente -> cliente.getNome().equalsIgnoreCase(nome)).findFirst().get();
	}

	public Cliente addCliente(Cliente cliente) {
		cliente.setId(Integer.toString(clientes.size()));
		clientes.add(cliente);
		return cliente;
	}

	public boolean removeCliente(String id) {
		for (Cliente cliente : clientes) {
			if (cliente.getId().equals(id)) {
				clientes.remove(cliente);
				return true;
			}
		}
		return false;
	}

	public Cliente updateCliente(Cliente cliente) {
		Cliente oldCliente = clientes.stream().filter(cl -> cl.getId().equals(cliente.getId())).findFirst().get();
		if (oldCliente != null) {
			oldCliente = cliente;
		}
		
		return oldCliente;
	}

	private void populateClientes() throws ParseException {
		CidadeDAO cidadeDAO = CidadeDAO.getInstance();
		Cliente a = new Cliente();
		a.setId("0");
		a.setNome("Joao da Silva");
		a.setSexo(Sexos.M);
		a.setDataNascimento("12/01/1982");
		a.setCidade(cidadeDAO.getCidadeById("0"));

		Cliente b = new Cliente();
		b.setId("1");
		b.setNome("Maria dos Santos");
		b.setSexo(Sexos.F);
		b.setDataNascimento("20/08/1995");
		b.setCidade(cidadeDAO.getCidadeById("1"));

		Cliente c = new Cliente();
		c.setId("2");
		c.setNome("Ana dos Santos");
		c.setSexo(Sexos.F);
		c.setDataNascimento("15/01/2000");
		c.setCidade(cidadeDAO.getCidadeById("1"));

		clientes.add(a);
		clientes.add(b);
		clientes.add(c);

	}

}
