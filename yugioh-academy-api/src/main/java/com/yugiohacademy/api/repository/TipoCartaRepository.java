package com.yugiohacademy.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.TipoCarta;

@Repository
public interface TipoCartaRepository extends JpaRepository<TipoCarta, Integer> {

}
