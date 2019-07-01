package com.gado.apirest.controller;

import com.gado.apirest.model.Medicamento;
import com.gado.apirest.repository.MedicamentoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gados")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @GetMapping("/medicamentos")
    @ApiOperation(value = "Retorna uma lista de 'Medicamentos'")
    public List<Medicamento> listaMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @GetMapping("/medicamento/{id}")
    @ApiOperation(value = "Retorna um único 'Medicamento', passando um id como parâmetro")
    public Medicamento listaMedicamentoUnico(@PathVariable(value = "id") long id) {
        return medicamentoRepository.findById(id);
    }

    @PostMapping("/medicamento")
    @ApiOperation(value = "Salva um 'Medicamento'")
    public Medicamento salvaMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @DeleteMapping("/medicamento")
    @ApiOperation(value = "Deleta um 'Medicamento'")
    public void deletaMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoRepository.delete(medicamento);
    }

    @PutMapping("/medicamento")
    @ApiOperation(value = "Atualiza um 'Medicamento'")
    public Medicamento atualizaMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }
}
