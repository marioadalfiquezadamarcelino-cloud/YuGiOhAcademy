package com.yugiohacademy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.CartaInvocacion;
import com.yugiohacademy.api.entity.CartaInvocacionId;

@Repository
public interface CartaInvocacionRepository
        extends JpaRepository<CartaInvocacion, CartaInvocacionId> {

}

