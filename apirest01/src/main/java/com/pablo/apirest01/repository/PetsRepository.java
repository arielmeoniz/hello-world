package com.pablo.apirest01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablo.apirest01.model.Pets;

public interface PetsRepository extends JpaRepository<Pets, Long> {

}
