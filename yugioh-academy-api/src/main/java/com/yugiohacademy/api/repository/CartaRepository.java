package com.yugiohacademy.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {

}