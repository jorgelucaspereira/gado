package com.gado.apirest.controllers;

import com.gado.apirest.models.Gasto;
import com.gado.apirest.repositories.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class GastoController {

    @Autowired
    GastoRepository gastoRepository;

    @GetMapping("/gastos")
    public List<Gasto> listaGasto(){
        return gastoRepository.findAll();
    }

    @GetMapping("/gasto/{id}")
    public Gasto listaGastoUnico(@PathVariable(value = "id") long id){
        return gastoRepository.findById(id);
    }

    @PostMapping("/gasto")
    public Gasto salvaGasto(@RequestBody Gasto gasto) {
        return gastoRepository.save(gasto);
    }
}
