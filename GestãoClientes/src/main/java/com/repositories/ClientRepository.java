package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long>{

}
