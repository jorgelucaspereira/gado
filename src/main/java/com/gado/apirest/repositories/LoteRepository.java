package com.gado.apirest.repositories;

import com.gado.apirest.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<Lote, Long> {

    Lote findById(long id);

}
