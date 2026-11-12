package com.yugiohacademy.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.CartaEstrategia;
import com.yugiohacademy.api.entity.CartaEstrategiaId;

@Repository
public interface CartaEstrategiaRepository
        extends JpaRepository<CartaEstrategia, CartaEstrategiaId> {

}

