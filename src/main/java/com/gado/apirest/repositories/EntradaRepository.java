package com.gado.apirest.repositories;

import com.gado.apirest.models.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    Entrada findById(long id);

}
