package com.gado.apirest.repositories;

import com.gado.apirest.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal findById(long id);

}
