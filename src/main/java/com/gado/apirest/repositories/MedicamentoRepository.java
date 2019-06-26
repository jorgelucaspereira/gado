package com.gado.apirest.repositories;

import com.gado.apirest.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Medicamento findById(long id);

}
