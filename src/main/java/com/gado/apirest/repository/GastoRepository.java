package com.gado.apirest.repository;

import com.gado.apirest.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

    Gasto findById(long id);


}
