package com.gado.apirest.controllers;

import com.gado.apirest.models.Saida;
import com.gado.apirest.repositories.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class SaidaController {

    @Autowired
    SaidaRepository saidaRepository;

    @GetMapping("/saidas")
    public List<Saida> listaSaida(){
        return saidaRepository.findAll();
    }

    @GetMapping("/saida/{id}")
    public Saida listaSaidaUnica(@PathVariable(value = "id") long id){
        return saidaRepository.findById(id);
    }
}
