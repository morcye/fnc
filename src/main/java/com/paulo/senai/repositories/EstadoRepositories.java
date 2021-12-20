package com.paulo.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.senai.domain.Estado;

public interface EstadoRepositories extends JpaRepository<Estado, Integer> {

}