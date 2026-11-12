package com.yugiohacademy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.Estrategia;

@Repository
public interface EstrategiaRepository extends JpaRepository<Estrategia, Integer> {

}
