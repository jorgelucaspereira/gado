package com.gado.apirest.repository;

import com.gado.apirest.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Medicamento findById(long id);

}
