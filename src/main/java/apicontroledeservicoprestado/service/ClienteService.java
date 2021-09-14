package apicontroledeservicoprestado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicontroledeservicoprestado.entity.Cliente;
import apicontroledeservicoprestado.repository.ClienteRepository;

@Service
public class ClienteService {

	ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente salvar(Cliente cliente) {

		return clienteRepository.save(cliente);
	}
	
	
}
