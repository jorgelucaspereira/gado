package com.gado.apirest.controllers;

import com.gado.apirest.models.Lote;
import com.gado.apirest.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class LoteController {

    @Autowired
    LoteRepository loteRepository;

    @GetMapping("/lotes")
    public List<Lote> listaLote() {
        return loteRepository.findAll();
    }

    @GetMapping("/lote/{id}")
    public Lote listaLoteUnico(@PathVariable(value = "id") long id) {
        return loteRepository.findById(id);
    }

    @PostMapping("/lote")
    public Lote salvaLote(@RequestBody Lote lote) {
        return loteRepository.save(lote);
    }

    @DeleteMapping("/lote")
    public void deletaLote(@RequestBody Lote lote) {
        loteRepository.delete(lote);
    }

    @PutMapping("/lote")
    public Lote atualizaLote(@RequestBody Lote lote) {
        return loteRepository.save(lote);
    }
}
