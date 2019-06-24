package com.gado.apirest.repositories;

import com.gado.apirest.models.Terreno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrenoRepository extends JpaRepository<Terreno, Long> {

    Terreno findById(long id);

}
