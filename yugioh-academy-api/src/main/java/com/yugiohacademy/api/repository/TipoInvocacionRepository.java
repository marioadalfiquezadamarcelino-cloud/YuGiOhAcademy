package com.yugiohacademy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.TipoInvocacion;

@Repository
public interface TipoInvocacionRepository extends JpaRepository<TipoInvocacion, Integer> {

}
