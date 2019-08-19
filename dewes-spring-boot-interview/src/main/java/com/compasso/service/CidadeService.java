package com.compasso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.compasso.dao.CidadeDAO;
import com.compasso.model.Cidade;

@Service
public class CidadeService {

	CidadeDAO cidadeDAO = CidadeDAO.getInstance();

	/**
	 * Consulta todas as Cidades cadastradas
	 * @return	todas as Cidades cadastradas
	 */
	public List<Cidade> getAll() {
		return cidadeDAO.getAll();
	}

	/**
	 * Consulta uma Cidade pelo id
	 * @param id	id da Cidade
	 * @return	Cidade
	 */
	public Cidade getCidadeById(String id) {
		return cidadeDAO.getCidadeById(id);
	}

	/**
	 * Consulta uma Cidade pelo nome
	 * @param nome	nome da Cidade
	 * @return	Cidade
	 */
	public Cidade getCidadeByNome(String nome) {
		return cidadeDAO.getCidadeByNome(nome);
	}
	
	/**
	 * Consulta todas as Cidades de um Estado
	 * @param estado	Estado das Cidades
	 * @return	lista de Cidades
	 */
	public List<Cidade> getCidadesByEstado(String estado) {
		return cidadeDAO.getCidadesByEstado(estado);
	}

	/**
	 * Cadastra uma nova Cidade
	 * @param cidade	nova Cidade
	 * @return	{@code true} se a Cidade foi cadastrada com sucesso, {@code false} caso contrario
	 */
	public Cidade addCidade(Cidade cidade) {
		return cidadeDAO.addCidade(cidade);
	}

}
