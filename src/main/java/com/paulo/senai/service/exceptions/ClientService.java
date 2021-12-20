package com.paulo.senai.service.exceptions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulo.senai.domain.Cliente;
import com.paulo.senai.repositories.ClienteRepositories;
import com.paulo.senai.repositories.EnderecoRepositories;


@Service
public class ClientService {

	@Autowired
	private ClienteRepositories cli;
	
	@Autowired
	private EnderecoRepositories enderecoRepositories;
	

	public Cliente buscar(Integer idCliente) {
		
		 Optional<Cliente> obj = cli.findById(idCliente);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Número de id não encontro. Id: " + idCliente + ", tipo: "
				 + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		return cli.findAll();
	}
	
	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = cli.save(obj);
		enderecoRepositories.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		
		buscar(obj.getIdCliente());
		
		return cli.save(obj);
	}
	
	public void delete (Integer id) {
		buscar(id);
		cli.deleteById(id);
	}
	
}
