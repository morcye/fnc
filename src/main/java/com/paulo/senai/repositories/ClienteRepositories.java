package com.paulo.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.senai.domain.Cliente;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

}