package com.compasso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.compasso.dao.CidadeDAO;
import com.compasso.dao.ClienteDAO;
import com.compasso.model.Cliente;

@Service
public class ClienteService {

	ClienteDAO clienteDAO = ClienteDAO.getInstance();
	CidadeDAO cidadeDAO = CidadeDAO.getInstance();

	/**
	 * Consulta todos os Clientes cadastrados
	 * @return todos os Clientes cadastrados
	 */
	public List<Cliente> getAll() {
		return clienteDAO.getAll();
	}

	/**
	 * Consulta Cliente por id
	 * @param id	id do Cliente
	 * @return	Cliente
	 */
	public Cliente getClienteById(String id) {
		return clienteDAO.getClienteById(id);
	}

	/**
	 * Consulta Cliente por nome
	 * @param nome	nome do Cliente
	 * @return	Cliente
	 */
	public Cliente getClienteByNome(String nome) {
		return clienteDAO.getClienteByNome(nome);
	}

	/**
	 * Cadastra novo Cliente
	 * @param cliente	Cliente a ser cadastrado
	 * @return {@code true} se a Cidade foi cadastrada com sucesso, {@code false} caso contrario	
	 */
	public Cliente addCliente(Cliente cliente) {
		cliente.setCidade(cidadeDAO.getCidadeById(cliente.getCidade().getId()));
		return clienteDAO.addCliente(cliente);
	}

	/**
	 * Remove um Cliente
	 * @param id	id do Cliente
	 * @return	{@code true} se a Cidade foi cadastrada com sucesso, {@code false} caso contrario
	 */
	public boolean removeCliente(String id) {
		return clienteDAO.removeCliente(id);
	}

	/**
	 * Atualiza o nome do Cliente
	 * @param cliente	Cliente a ser atualizado
	 * @return Cliente atualizado
	 */
	public Cliente updateClienteNome(Cliente cliente) {
		Cliente oldCliente = clienteDAO.getClienteById(cliente.getId());
		oldCliente.setNome(cliente.getNome());
		return clienteDAO.updateCliente(oldCliente);
	}

}
