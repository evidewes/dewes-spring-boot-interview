package com.compasso.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.model.Cidade;
import com.compasso.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	CidadeService cidadeService;

	@GetMapping("/all")
	public List<Cidade> getAll() {
		return cidadeService.getAll();
	}

	@GetMapping("/byId/{id}")
	public Cidade getCidade(@PathVariable("id") String id) {
		return cidadeService.getCidadeById(id);
	}

	@GetMapping("/byNome/{nome}")
	public Cidade getCidadeByNome(@PathVariable("nome") String nome) {
		return cidadeService.getCidadeByNome(nome);
	}

	@GetMapping("/byEstado/{estado}")
	public List<Cidade> getCidadeByEstado(@PathVariable("estado") String estado) {
		return cidadeService.getCidadesByEstado(estado);
	}

	@PostMapping(path = "/", consumes = "application/json")
	public ResponseEntity<Cidade> persistCidade(@RequestBody Cidade cidade) throws Exception {

		cidade = cidadeService.addCidade(cidade);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
