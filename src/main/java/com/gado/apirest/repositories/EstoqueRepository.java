package com.gado.apirest.repositories;

import com.gado.apirest.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Estoque findById(long id);

}
