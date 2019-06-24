package com.gado.apirest.controllers;

import com.gado.apirest.models.AnimalTipo;
import com.gado.apirest.repositories.AnimalTipoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Animais")
@CrossOrigin(origins = "*")
public class AnimalTipoController {

    @Autowired
    AnimalTipoRepository animalTipoRepository;

    @GetMapping("/animaisTipo")
    @ApiOperation(value = "Retorna uma lista de 'AnimaisTipo'")
    public List<AnimalTipo> listaAnimais() {
        return animalTipoRepository.findAll();
    }

    @GetMapping("/animalTipo/{id}")
    @ApiOperation(value = "Retorna um único 'AnimalTipo', passando um id como parâmetro")
    public AnimalTipo listaAnimalTipoUnico(@PathVariable(value = "id") long id) {
        return animalTipoRepository.findById(id);
    }

    @PostMapping("/animalTipo")
    @ApiOperation(value = "Salva um 'AnimalTipo'")
    public AnimalTipo salvaAnimalTipo(@RequestBody AnimalTipo animalTipo) {
        return animalTipoRepository.save(animalTipo);
    }

    @DeleteMapping("/animalTipo")
    @ApiOperation(value = "Deleta um 'AnimalTipo'")
    public void deletaAnimalTipo(@RequestBody AnimalTipo animalTipo) {
        animalTipoRepository.delete(animalTipo);
    }

    @PutMapping("/animalTipo")
    @ApiOperation(value = "Atualiza um 'AnimalTipo'")
    public AnimalTipo atualizaAnimalTipo(@RequestBody AnimalTipo animalTipo) {
        return animalTipoRepository.save(animalTipo);
    }
}
