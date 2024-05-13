package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.ClientModel;
import com.repositories.ClientRepository;
import com.repositories.ClientRepositoryImpl;

	//DESCOBERTA: AQUI EU VOU ESTAR USANDO O SERVICE DE QUALQUER FORMA POIS ESTAREI CHAMANDO OS METODOS FINDBYID SAVE ETC... QUE PERTENCEM AO SERVER
@Service
public class ClientServices {
	@Autowired
	ClientRepositoryImpl clientRepositoryImpl;
	
	public ClientModel createCliente(ClientModel client) {
		return clientRepositoryImpl.saveClient(null);
	}
	
	
	
	public void isempty() {
		
	}
	
	public void isunique() {
		
	}
}
