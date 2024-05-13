package com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtos.ClientDTO;
import com.models.ClientModel;
import com.repositories.ClientRepository;
import com.services.ClientServices;

@RestController
public class ClientController {
	
	//ta faltando botar um @responsebody em alguns mas nao sei pra que serve
	
	@Autowired
	ClientRepository clientRepository;
	
	ClientServices clientservice;
	
	@PostMapping("/clients")
		private void createClient() {
			clientservice.createCliente(ClientModel client);
	}
	
	@GetMapping("/clients")
	private List<ClientModel> getAllClient() { //fazer ele retornar um reponseentity(ver qual é melhor)
		List<ClientModel> clients = clientRepository.findAll();
		//isempty
		return clients;	
		}
	
	@GetMapping("/clients/{id}")
	private Optional<ClientModel> getOneClient(@PathVariable(value="id") long id) { //fazer ele retornar um reponseentity(ver qual é melhor)
		Optional<ClientModel> client = clientRepository.findById(id);
		//isempty
		return client;
	}
	
	@PutMapping("/clients/{id}")
	private void putClient(@PathVariable(value="id") long id, ClientDTO dtoClient) {
		Optional<ClientModel> entityClient = clientRepository.findById(id);
		//validao isempty
		//aparentemento eu devia colocar esse entity em um model?? nn entendi porque
		BeanUtils.copyProperties(dtoClient, entityClient);
	}
	
	@DeleteMapping("/client/{id}")
	private void deleteClient(@PathVariable(value="id") long id) {
		clientRepository.deleteById(id); //a entidade nao pode ser null para a função retornar, entao talvez tenha que verificar esse tambem
	}
	
	
	
}
