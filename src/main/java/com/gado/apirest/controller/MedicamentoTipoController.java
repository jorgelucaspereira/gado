package com.gado.apirest.controller;

import com.gado.apirest.model.MedicamentoTipo;
import com.gado.apirest.repository.MedicamentoTipoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gados")
@CrossOrigin(origins = "*")
public class MedicamentoTipoController {

    @Autowired
    MedicamentoTipoRepository medicamentoTipoRepository;

    @GetMapping("/medicamentos-tipos")
    @ApiOperation(value = "Retorna uma lista de 'MedicamentosTipos'")
    public List<MedicamentoTipo> listaMedicamentosTipos() {
        return medicamentoTipoRepository.findAll();
    }

    @GetMapping("/medicamento-tipo/{id}")
    @ApiOperation(value = "Retorna um único 'MedicamentoTipo', passando um id como parâmetro")
    public MedicamentoTipo listaMedicamentoTipoUnico(@PathVariable(value = "id") long id) {
        return medicamentoTipoRepository.findById(id);
    }

    @PostMapping("/medicamento-tipo")
    @ApiOperation(value = "Salva um 'MedicamentoTipo'")
    public MedicamentoTipo salvaMedicamentoTipo(@RequestBody MedicamentoTipo medicamentoTipo) {
        return medicamentoTipoRepository.save(medicamentoTipo);
    }

    @DeleteMapping("/medicamento-tipo")
    @ApiOperation(value = "Deleta um 'MedicamentoTipo'")
    public void deletaMedicamentoTipo(@RequestBody MedicamentoTipo medicamentoTipo) {
        medicamentoTipoRepository.delete(medicamentoTipo);
    }

    @PutMapping("/medicamento-tipo")
    @ApiOperation(value = "Atualiza um 'MedicamentoTipo'")
    public MedicamentoTipo atualizaMedicamentoTipo(@RequestBody MedicamentoTipo medicamentoTipo) {
        return medicamentoTipoRepository.save(medicamentoTipo);
    }
}
