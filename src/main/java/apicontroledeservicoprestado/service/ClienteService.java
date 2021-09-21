package apicontroledeservicoprestado.service;

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
			   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		
	}

}
