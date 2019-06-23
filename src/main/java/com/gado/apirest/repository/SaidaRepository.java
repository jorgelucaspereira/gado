package com.gado.apirest.repository;

import com.gado.apirest.models.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long> {

    Saida findById(long id);

}
