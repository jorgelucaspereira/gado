package com.gado.apirest.controllers;

import com.gado.apirest.models.Vendedor;
import com.gado.apirest.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class VendedorController {

    @Autowired
    VendedorRepository vendedorRepository;

    @GetMapping("/vendedores")
    public List<Vendedor> listaVendedor(){
        return vendedorRepository.findAll();
    }

    @GetMapping("/vendedor/{id}")
    public Vendedor listaVendedorUnico(@PathVariable(value = "id") long id){
        return vendedorRepository.findById(id);
    }

    @PostMapping("/vendedor")
    public Vendedor salvaVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
}
