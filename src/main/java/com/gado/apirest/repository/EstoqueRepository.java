package com.gado.apirest.repository;

import com.gado.apirest.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Estoque findById(long id);

}
