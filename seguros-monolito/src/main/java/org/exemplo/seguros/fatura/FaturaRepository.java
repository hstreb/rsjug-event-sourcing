package org.exemplo.seguros.fatura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
    List<Fatura> findByApoliceId(Long idApolice);
}
