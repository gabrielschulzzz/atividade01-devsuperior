package com.devsuperior.exercicio01.repositories;

import com.devsuperior.exercicio01.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClient extends JpaRepository<Client, Long> {
}
