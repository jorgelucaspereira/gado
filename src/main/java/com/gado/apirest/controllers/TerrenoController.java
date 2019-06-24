package com.gado.apirest.controllers;

import com.gado.apirest.models.Terreno;
import com.gado.apirest.repositories.TerrenoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Rerrenos")
@CrossOrigin(origins = "*")
public class TerrenoController {

    @Autowired
    TerrenoRepository terrenoRepository;

    @GetMapping("/terrenos")
    @ApiOperation(value = "Retorna uma lista de 'Terrenos'")
    public List<Terreno> listaAnimais() {
        return terrenoRepository.findAll();
    }

    @GetMapping("/terreno/{id}")
    @ApiOperation(value = "Retorna um único 'Terreno', passando um id como parâmetro")
    public Terreno listaTerrenoUnico(@PathVariable(value = "id") long id) {
        return terrenoRepository.findById(id);
    }

    @PostMapping("/terreno")
    @ApiOperation(value = "Salva um 'Terreno'")
    public Terreno salvaTerreno(@RequestBody Terreno terreno) {
        return terrenoRepository.save(terreno);
    }

    @DeleteMapping("/terreno")
    @ApiOperation(value = "Deleta um 'Terreno'")
    public void deletaTerreno(@RequestBody Terreno terreno) {
        terrenoRepository.delete(terreno);
    }

    @PutMapping("/terreno")
    @ApiOperation(value = "Atualiza um 'Terreno'")
    public Terreno atualizaTerreno(@RequestBody Terreno terreno) {
        return terrenoRepository.save(terreno);
    }
}
