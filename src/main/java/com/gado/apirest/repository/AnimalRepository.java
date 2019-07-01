package com.gado.apirest.repository;

import com.gado.apirest.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal findById(long id);

}
