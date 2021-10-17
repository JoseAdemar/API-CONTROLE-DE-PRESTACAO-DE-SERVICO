package apicontroledeservicoprestado.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apicontroledeservicoprestado.entity.Cliente;
import apicontroledeservicoprestado.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> persisteCliente(@RequestBody @Valid Cliente cliente) {

		Cliente persiste = clienteService.persisteUmCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(persiste);

	}

	@GetMapping("{id}")
	public ResponseEntity<Cliente> buscaClientePorId(@PathVariable Long id) {

		Cliente buscarClientePorId = clienteService.buscaUmClientePorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(buscarClientePorId);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listaDeVisitantes() {

		List<Cliente> listaVisitante = clienteService.listarTodosClientes();

		return ResponseEntity.status(HttpStatus.OK).body(listaVisitante);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> deletaClientePorId(@PathVariable Long id){
		
		clienteService.deletarClientePorId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente, @PathVariable Long id) {

		Cliente atualizaUmCliente = clienteService.atualizarCliente(cliente, id);
		return ResponseEntity.status(HttpStatus.OK).body(atualizaUmCliente);

	}
	
}
