package com.gado.apirest.repositories;

import com.gado.apirest.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Vendedor findById(long id);

}
