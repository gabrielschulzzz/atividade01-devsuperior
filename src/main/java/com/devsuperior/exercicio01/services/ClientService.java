package com.devsuperior.exercicio01.services;


import com.devsuperior.exercicio01.services.exceptions.DatabaseException;
import com.devsuperior.exercicio01.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.exercicio01.dto.ClientDTO;
import com.devsuperior.exercicio01.entities.Client;
import com.devsuperior.exercicio01.repositories.IClient;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    private IClient repository;
    
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pagerequest) {
    	Page<Client> list = repository.findAll(pagerequest);
    	
    	return list.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findOne(Long id) {
        Optional<Client> obj = repository.findById(id);

        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setName(dto.getName());

        entity = repository.save(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getOne(id);

            entity.setBirthDate(dto.getBirthDate());
            entity.setChildren(dto.getChildren());
            entity.setCpf(dto.getCpf());
            entity.setIncome(dto.getIncome());
            entity.setName(dto.getName());

            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void remove(Long id) {
        try {
            repository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
