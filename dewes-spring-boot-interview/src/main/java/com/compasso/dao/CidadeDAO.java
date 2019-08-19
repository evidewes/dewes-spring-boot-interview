package com.compasso.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.compasso.model.Cidade;
import com.compasso.model.Estados;

public class CidadeDAO {

	private static CidadeDAO singleInstance = null;

	List<Cidade> cidades = null;

	private CidadeDAO() {
		cidades = new LinkedList<>();

		this.populateCidades();
	}

	public static CidadeDAO getInstance() {
		if (singleInstance == null) {
			singleInstance = new CidadeDAO();
		}

		return singleInstance;
	}

	public List<Cidade> getAll() {
		return cidades;
	}

	public Cidade getCidadeById(String id) {
		return cidades.stream().filter(cidade -> cidade.getId().equals(id)).findFirst().get();
	}

	public Cidade getCidadeByNome(String nome) {
		return cidades.stream().filter(cidade -> cidade.getNome().equals(nome)).findFirst().get();
	}

	public List<Cidade> getCidadesByEstado(String estado) {
		return cidades.stream().filter(cidade -> cidade.getEstado().toString().equalsIgnoreCase(estado))
				.collect(Collectors.toList());
	}

	public Cidade addCidade(Cidade cidade) {
		cidade.setId(Integer.toString(cidades.size()));
		cidades.add(cidade);
		return cidade;

	}

	private void populateCidades() {
		Cidade floripa = new Cidade();
		floripa.setId("0");
		;
		floripa.setNome("Florianópolis");
		floripa.setEstado(Estados.SC);

		Cidade poa = new Cidade();
		poa.setId("1");
		poa.setNome("Porto Alegre");
		poa.setEstado(Estados.RS);

		Cidade blumenau = new Cidade();
		blumenau.setId("2");
		blumenau.setNome("Blumenau");
		blumenau.setEstado(Estados.SC);

		cidades.add(floripa);
		cidades.add(poa);
		cidades.add(blumenau);
	}
}
