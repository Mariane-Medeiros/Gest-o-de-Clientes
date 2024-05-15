package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.controllers.ClientController;
import com.dtos.ClientDTO;
import com.models.ClientModel;
import com.repositories.ClientRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;


@Service
public class ClientServices {
	
	    @Autowired
	    private ClientRepository clientRepository;
		@Autowired
		ClientModel client;
		
	    
	public ResponseEntity saveClient(ClientDTO clientDto) {
		var clientModel = new ClientModel();
		BeanUtils.copyProperties(clientDto, clientModel);
		return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));
	}
	
	public ResponseEntity updateClient(ClientDTO clientDto, @PathVariable(value="id") Long id) {
		clientRepository.existsById(id);
		Optional<ClientModel> optionalClientModel= clientRepository.findById(id);
	    ClientModel clientModel = optionalClientModel.get();
	    BeanUtils.copyProperties(clientDto, clientModel);
		return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));
	}
	
	public ResponseEntity getOneClient(@PathVariable(value="id") Long id) {
		Optional<ClientModel> client = clientRepository.findById(id);
		Link link = linkTo(ClientController.class).slash(this.client.getId()).withSelfRel();	
		client.get().add(link);
		return ResponseEntity.status(HttpStatus.OK).body(client);
	}
	
	public ResponseEntity<List<ClientModel>> getAllClient() {
		List<ClientModel> clientList = clientRepository.findAll();
			for (ClientModel client : clientList) {
				Link link = linkTo(ClientController.class).slash(client.getId()).withSelfRel();	
				client.add(link);
			}
		return ResponseEntity.status(HttpStatus.OK).body(clientList);
	}
	
	public ResponseEntity deleteClient(@PathVariable(value="id") Long id) {
		Optional<ClientModel> clientModel= clientRepository.findById(id);
		clientRepository.existsById(id);
		clientRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Client deleted");
	}
}
