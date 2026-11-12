package com.yugiohacademy.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugiohacademy.api.entity.Regla;

@Repository
public interface ReglaRepository extends JpaRepository<Regla, Integer> {

}
