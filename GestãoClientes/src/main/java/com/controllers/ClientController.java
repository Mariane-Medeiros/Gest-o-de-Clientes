package com.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtos.ClientDTO;
import com.models.ClientModel;
import com.repositories.ClientRepository;
import com.services.ClientServices;

@RestController
public class ClientController {

	@Autowired
	ClientServices clientservice;
	

	@PostMapping("/clients")
		public ResponseEntity createClient(@RequestBody ClientDTO clientDto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(clientservice.saveClient(clientDto));
		}
	

	@GetMapping("/clients")
	public ResponseEntity getAllClients() {
		return ResponseEntity.status(HttpStatus.OK).body(clientservice.getAllClient());
	}		
	
	@GetMapping("/clients/{id}")
	public ResponseEntity getOneClient(@PathVariable(value = "id")long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientservice.getOneClient(id));
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity putClient(@PathVariable(value = "id")long id, @RequestBody ClientDTO clientDto) {
		return ResponseEntity.status(HttpStatus.OK).body(clientservice.updateClient(clientDto, id));
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity deleteClient(@PathVariable(value = "id")long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientservice.deleteClient(id));
	}
	
	
	
}
