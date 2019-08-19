package com.compasso.model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente {

	private String id;
	private String nome;
	private Sexos sexo;
	private LocalDate dataNascimento;
	private Integer idade;
	private Cidade cidade;

	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexos getSexo() {
		return sexo;
	}

	public void setSexo(Sexos sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws ParseException {
		this.dataNascimento = LocalDate.parse(dataNascimento, dateTimeFormatter);
	}

	public Integer getIdade() {
		if(this.dataNascimento == null) {
			return null;
		}
		idade = Period.between(this.dataNascimento, LocalDate.now()).getYears();
		return idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
