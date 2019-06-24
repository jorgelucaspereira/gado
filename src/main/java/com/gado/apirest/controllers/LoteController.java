package com.gado.apirest.controllers;

import com.gado.apirest.models.Lote;
import com.gado.apirest.repositories.LoteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Lotes")
@CrossOrigin(origins = "*")
public class LoteController {

    @Autowired
    LoteRepository loteRepository;

    @GetMapping("/lotes")
    @ApiOperation(value = "Retorna uma lista de 'Lotes'")
    public List<Lote> listaLote() {
        return loteRepository.findAll();
    }

    @GetMapping("/lote/{id}")
    @ApiOperation(value = "Retorna um único 'Lote', passando um id como parâmetro")
    public Lote listaLoteUnico(@PathVariable(value = "id") long id) {
        return loteRepository.findById(id);
    }

    @PostMapping("/lote")
    @ApiOperation(value = "Salva um 'Lote'")
    public Lote salvaLote(@RequestBody Lote lote) {
        return loteRepository.save(lote);
    }

    @DeleteMapping("/lote")
    @ApiOperation(value = "Deleta um 'Lote'")
    public void deletaLote(@RequestBody Lote lote) {
        loteRepository.delete(lote);
    }

    @PutMapping("/lote")
    @ApiOperation(value = "Atualiza um 'Lote'")
    public Lote atualizaLote(@RequestBody Lote lote) {
        return loteRepository.save(lote);
    }
}
