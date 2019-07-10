package com.gado.apirest.repository;

import com.gado.apirest.model.Gasto;
import com.gado.apirest.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaidaRepository extends JpaRepository<Saida, Long> {

    Saida findById(long id);

    List<Saida> findAllByGasto(Gasto gasto);
}
