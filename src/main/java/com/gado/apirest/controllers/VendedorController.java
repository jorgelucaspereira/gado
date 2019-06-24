package com.gado.apirest.controllers;

import com.gado.apirest.models.Vendedor;
import com.gado.apirest.repositories.VendedorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gados")
@CrossOrigin(origins = "*")
public class VendedorController {

    @Autowired
    VendedorRepository vendedorRepository;

    @GetMapping("/vendedores")
    @ApiOperation(value = "Retorna uma lista de 'Vendedores'")
    public List<Vendedor> listaVendedor() {
        return vendedorRepository.findAll();
    }

    @GetMapping("/vendedor/{id}")
    @ApiOperation(value = "Retorna um único 'Vendedor', passando um id como parâmetro")
    public Vendedor listaVendedorUnico(@PathVariable(value = "id") long id) {
        return vendedorRepository.findById(id);
    }

    @PostMapping("/vendedor")
    @ApiOperation(value = "Salva um 'Vendedor'")
    public Vendedor salvaVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @DeleteMapping("/vendedor")
    @ApiOperation(value = "Deleta um 'Vendedor'")
    public void deletaVendedor(@RequestBody Vendedor vendedor) {
        vendedorRepository.delete(vendedor);
    }

    @PutMapping("/vendedor")
    @ApiOperation(value = "Atualiza um 'Vendedor'")
    public Vendedor atualizaVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
}
