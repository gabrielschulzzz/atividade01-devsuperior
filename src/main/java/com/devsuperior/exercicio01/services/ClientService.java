package com.devsuperior.exercicio01.services;

import com.devsuperior.exercicio01.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private Client repository;
}
