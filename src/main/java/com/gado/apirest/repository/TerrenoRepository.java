package com.gado.apirest.repository;

import com.gado.apirest.model.Terreno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrenoRepository extends JpaRepository<Terreno, Long> {

    Terreno findById(long id);

}
