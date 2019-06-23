package com.gado.apirest.controller;

import com.gado.apirest.models.Gasto;
import com.gado.apirest.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
