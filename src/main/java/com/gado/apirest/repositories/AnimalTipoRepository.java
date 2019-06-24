package com.gado.apirest.repositories;

import com.gado.apirest.models.AnimalTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTipoRepository extends JpaRepository<AnimalTipo, Long> {

    AnimalTipo findById(long id);

}
