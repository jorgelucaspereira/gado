package com.gado.apirest.repositories;

import com.gado.apirest.models.MedicamentoTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoTipoRepository extends JpaRepository<MedicamentoTipo, Long> {

    MedicamentoTipo findById(long id);

}
