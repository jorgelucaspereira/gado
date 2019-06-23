package com.gado.apirest.controllers;

import com.gado.apirest.models.Entrada;
import com.gado.apirest.repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class EntradaController {

    @Autowired
    EntradaRepository entradaRepository;

    @GetMapping("/entradas")
    public List<Entrada> listaEntradas(){
        return entradaRepository.findAll();
    }

    @GetMapping("/entrada/{id}")
    public Entrada listaEntradaUnica(@PathVariable(value = "id") long id){
        return entradaRepository.findById(id);
    }
}
