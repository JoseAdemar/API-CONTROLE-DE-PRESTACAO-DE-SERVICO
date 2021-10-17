package apicontroledeservicoprestado.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apicontroledeservicoprestado.entity.Cliente;
import apicontroledeservicoprestado.repository.ClienteRepository;

@Service
public class ClienteService {

	ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente persisteUmCliente(Cliente cliente) {

		return clienteRepository.save(cliente);
	}
	
	
	public Cliente buscaUmClientePorId(Long id) {

		return clienteRepository.findById(id)
			   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}
	
	public List<Cliente> listarTodosClientes() {

		return clienteRepository.findAll();

	}
	
	
	public void deletarClientePorId(Long id) {

		clienteRepository.findById(id).map(cliente -> {
			clienteRepository.delete(cliente);
			return void.class.getTypeParameters();
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));

	}
	
	public Cliente atualizarCliente(Cliente cliente, Long id) {

		Cliente atualizaCliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		if (atualizaCliente != null) {

			BeanUtils.copyProperties(cliente, atualizaCliente, "id");
			clienteRepository.save(atualizaCliente);
		}
		return atualizaCliente;

	}
}
