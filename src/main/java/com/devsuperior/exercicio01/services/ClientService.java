package com.devsuperior.exercicio01.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.exercicio01.dto.ClientDTO;
import com.devsuperior.exercicio01.entities.Client;
import com.devsuperior.exercicio01.repositories.IClient;


@Service
public class ClientService {

    @Autowired
    private IClient repository;
    
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pagerequest) {
    	Page<Client> list = repository.findAll(pagerequest);
    	
    	return list.map(x -> new ClientDTO(x));
    }

}
