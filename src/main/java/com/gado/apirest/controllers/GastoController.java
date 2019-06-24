package com.gado.apirest.controllers;

import com.gado.apirest.models.Gasto;
import com.gado.apirest.repositories.GastoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gastos")
@CrossOrigin(origins = "*")
public class GastoController {

    @Autowired
    GastoRepository gastoRepository;

    @GetMapping("/gastos")
    @ApiOperation(value = "Retorna uma lista de 'Gastos'")
    public List<Gasto> listaGasto() {
        return gastoRepository.findAll();
    }

    @GetMapping("/gasto/{id}")
    @ApiOperation(value = "Retorna um único 'Gasto', passando um id como parâmetro")
    public Gasto listaGastoUnico(@PathVariable(value = "id") long id) {
        return gastoRepository.findById(id);
    }

    @PostMapping("/gasto")
    @ApiOperation(value = "Salva um 'Gasto'")
    public Gasto salvaGasto(@RequestBody Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    @DeleteMapping("/gasto")
    @ApiOperation(value = "Deleta um 'Gasto'")
    public void deletaGasto(@RequestBody Gasto gasto) {
        gastoRepository.delete(gasto);
    }

    @PutMapping("/gasto")
    @ApiOperation(value = "Atualiza um 'Gasto'")
    public Gasto atualizaGasto(@RequestBody Gasto gasto) {
        return gastoRepository.save(gasto);
    }
}
