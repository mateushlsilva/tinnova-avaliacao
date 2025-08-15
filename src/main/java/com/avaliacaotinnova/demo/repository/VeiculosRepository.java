package com.avaliacaotinnova.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avaliacaotinnova.demo.entity.Veiculos;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {

    @Query("SELECT v FROM Veiculos v " +
            "WHERE (:marca IS NULL OR v.marca = :marca) " +
            "AND (:ano IS NULL OR v.ano = :ano) " +
            "AND (:cor IS NULL OR v.cor = :cor)")
    List<Veiculos> findByFiltros(@Param("marca") String marca, @Param("ano") Integer ano, @Param("cor") String cor);
}
