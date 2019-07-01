package com.gado.apirest.repository;

import com.gado.apirest.model.MedicamentoTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoTipoRepository extends JpaRepository<MedicamentoTipo, Long> {

    MedicamentoTipo findById(long id);

}
