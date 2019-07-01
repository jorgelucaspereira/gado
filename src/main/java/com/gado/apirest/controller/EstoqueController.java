package com.gado.apirest.controller;

import com.gado.apirest.model.Estoque;
import com.gado.apirest.repository.EstoqueRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gados")
@CrossOrigin(origins = "*")
public class EstoqueController {

    @Autowired
    EstoqueRepository estoqueRepository;

    @GetMapping("/estoques")
    @ApiOperation(value = "Retorna uma lista de 'Estoques'")
    public List<Estoque> listaEstoques() {
        return estoqueRepository.findAll();
    }

    @GetMapping("/estoque/{id}")
    @ApiOperation(value = "Retorna um único 'Estoque', passando um id como parâmetro")
    public Estoque listaEstoqueUnico(@PathVariable(value = "id") long id) {
        return estoqueRepository.findById(id);
    }

    @PostMapping("/estoque")
    @ApiOperation(value = "Salva um 'Estoque'")
    public Estoque salvaEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @DeleteMapping("/estoque")
    @ApiOperation(value = "Deleta um 'Estoque'")
    public void deletaEstoque(@RequestBody Estoque estoque) {
        estoqueRepository.delete(estoque);
    }

    @PutMapping("/estoque")
    @ApiOperation(value = "Atualiza um 'Estoque'")
    public Estoque atualizaEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }
}
