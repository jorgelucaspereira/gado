package com.gado.apirest.controller;

import com.gado.apirest.model.Saida;
import com.gado.apirest.repository.SaidaRepository;
import com.gado.apirest.service.SaidasService;
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
public class SaidaController {

    @Autowired
    SaidaRepository saidaRepository;
    @Autowired private SaidasService saidaService;

    @GetMapping("/saidas")
    @ApiOperation(value = "Retorna uma lista de 'Saídas'")
    public List<Saida> listaSaidas() {
        return saidaRepository.findAll();
    }

    @GetMapping("/saida/{id}")
    @ApiOperation(value = "Retorna uma única 'Saída', passando um id como parâmetro")
    public Saida listaSaidaUnica(@PathVariable(value = "id") long id) {
        return saidaRepository.findById(id);
    }

    @PostMapping("/saida")
    @ApiOperation(value = "Salva uma 'Saída'")
    public Saida salvaSaida(@RequestBody Saida saida) {
        return saidaService.salvar(saida);
    }

    @DeleteMapping("/saida")
    @ApiOperation(value = "Deleta uma 'Saída'")
    public void deletaSaida(@RequestBody Saida saida) {
        saidaRepository.delete(saida);
    }

    @PutMapping("/saida")
    @ApiOperation(value = "Atualiza uma 'Saída'")
    public Saida atualizaSaida(@RequestBody Saida saida) {
        return saidaRepository.save(saida);
    }

    @GetMapping("/saidas/resumo")
    @ApiOperation(value = "Retorna uma lista de 'Saídas'")
    public Map listaResumoSaidas() {
        return saidaService.resumoSaidas();
    }
}
