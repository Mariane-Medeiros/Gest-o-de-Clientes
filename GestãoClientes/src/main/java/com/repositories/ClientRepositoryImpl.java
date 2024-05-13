package com.repositories;

import org.springframework.beans.BeanUtils;

import com.dtos.ClientDTO;
import com.models.ClientModel;

//nao sei se preciso dessa implementação, ela só esta dando problema

public class ClientRepositoryImpl implements ClientRepository {

	public void saveClient(ClientDTO dtoClient) {
		ClientModel entityClient = new ClientModel();
		//implementar correçao de erros(com uma classe especifica) caso o email nao seja unique
		BeanUtils.copyProperties(dtoClient, entityClient);
		}
}
