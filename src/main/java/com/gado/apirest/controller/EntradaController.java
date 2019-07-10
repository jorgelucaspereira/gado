package com.gado.apirest.controller;

import com.gado.apirest.model.Entrada;
import com.gado.apirest.repository.EntradaRepository;
import com.gado.apirest.service.EntradaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gados")
@CrossOrigin(origins = "*")
public class EntradaController {

    @Autowired
    EntradaRepository entradaRepository;
    @Autowired private EntradaService entradaService;

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

    @GetMapping("/entradas/resumo")
    @ApiOperation(value = "Retorna uma lista de 'Animais'")
    public Map listaResumoEntradas() {
        return entradaService.resumoEntradas();
    }
}
