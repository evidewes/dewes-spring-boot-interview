package com.compasso.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.model.Cliente;
import com.compasso.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/all")
	public List<Cliente> getAll() {
		return clienteService.getAll();
	}

	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable("id") String id) {
		return clienteService.getClienteById(id);
	}

	@GetMapping("byNome/{nome}")
	public Cliente getClienteByName(@PathVariable("nome") String nome) {
		return clienteService.getClienteByNome(nome);
	}

	@PostMapping(path = "/", consumes = "application/json")
	public ResponseEntity<Cliente> persistCliente(@RequestBody Cliente cliente) throws Exception {
		cliente = clienteService.addCliente(cliente);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Cliente> removeCliente(@PathVariable("id") String id) {
		if (clienteService.removeCliente(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.updateClienteNome(cliente);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
