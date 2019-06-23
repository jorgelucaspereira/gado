package com.gado.apirest.controllers;

import com.gado.apirest.models.Lote;
import com.gado.apirest.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class LoteController {

    @Autowired
    LoteRepository loteRepository;

    @GetMapping("/lotes")
    public List<Lote> listaLote(){
        return loteRepository.findAll();
    }

    @GetMapping("/lote/{id}")
    public Lote listaLoteUnico(@PathVariable(value = "id") long id){
        return loteRepository.findById(id);
    }
}
