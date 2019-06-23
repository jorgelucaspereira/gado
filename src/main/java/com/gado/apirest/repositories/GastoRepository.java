package com.gado.apirest.repositories;

import com.gado.apirest.models.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

    Gasto findById(long id);

}
