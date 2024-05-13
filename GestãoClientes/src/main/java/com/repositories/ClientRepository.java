package com.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}