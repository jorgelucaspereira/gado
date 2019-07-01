package com.gado.apirest.repository;

import com.gado.apirest.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    Entrada findById(long id);

}
