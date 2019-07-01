package com.gado.apirest.repository;

import com.gado.apirest.model.AnimalTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTipoRepository extends JpaRepository<AnimalTipo, Long> {

    AnimalTipo findById(long id);

}
