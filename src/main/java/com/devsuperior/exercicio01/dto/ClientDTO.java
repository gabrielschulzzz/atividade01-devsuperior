package com.devsuperior.exercicio01.dto;

import com.devsuperior.exercicio01.entities.Client;

import java.io.Serializable;
import java.time.Instant;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String cpf;

    private Double income;

    private Instant birthDate;

    private Integer children;

    public ClientDTO(Long id, String name, String cpf, java.lang.Double income, Instant birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }


    public ClientDTO(Client entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

    public ClientDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public java.lang.Double getIncome() {
        return income;
    }

    public void setIncome(java.lang.Double income) {
        this.income = income;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }
}
