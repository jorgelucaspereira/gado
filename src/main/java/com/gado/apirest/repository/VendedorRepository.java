package com.gado.apirest.repository;

import com.gado.apirest.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Vendedor findById(long id);

}
