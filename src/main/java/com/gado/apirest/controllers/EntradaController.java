package com.gado.apirest.controllers;

import com.gado.apirest.models.Entrada;
import com.gado.apirest.repositories.EntradaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Entradas")
@CrossOrigin(origins = "*")
public class EntradaController {

    @Autowired
    EntradaRepository entradaRepository;

    @GetMapping("/entradas")
    @ApiOperation(value = "Retorna uma lista de 'Entradas'")
    public List<Entrada> listaEntradas() {
        return entradaRepository.findAll();
    }

    @GetMapping("/entrada/{id}")
    @ApiOperation(value = "Retorna uma única 'Entrada', passando um id como parâmetro")
    public Entrada listaEntradaUnica(@PathVariable(value = "id") long id) {
        return entradaRepository.findById(id);
    }

    @PostMapping("/entrada")
    @ApiOperation(value = "Salva uma 'Entrada'")
    public Entrada salvaEntrada(@RequestBody Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    @DeleteMapping("/entrada")
    @ApiOperation(value = "Deleta uma 'Entrada'")
    public void deletaEntrada(@RequestBody Entrada entrada) {
        entradaRepository.delete(entrada);
    }

    @PutMapping("/entrada")
    @ApiOperation(value = "Atualiza uma 'Entrada'")
    public Entrada atualizaEntrada(@RequestBody Entrada entrada) {
        return entradaRepository.save(entrada);
    }
}
