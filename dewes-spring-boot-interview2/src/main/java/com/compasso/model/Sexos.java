package com.compasso.model;

public enum Sexos {
	M("Masculino"),
	F("Feminino");
	
	private final String sexo;

	private  Sexos(String sexo) {
		this.sexo = sexo;
	}
	
	public  String getSexo(){
		return sexo;
	}
}
