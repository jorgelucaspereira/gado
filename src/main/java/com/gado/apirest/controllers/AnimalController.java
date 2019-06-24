package com.gado.apirest.controllers;

import com.gado.apirest.models.Animal;
import com.gado.apirest.repositories.AnimalRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Animais")
@CrossOrigin(origins = "*")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @GetMapping("/animais")
    @ApiOperation(value = "Retorna uma lista de 'Animais'")
    public List<Animal> listaAnimais() {
        return animalRepository.findAll();
    }

    @GetMapping("/animal/{id}")
    @ApiOperation(value = "Retorna um único 'Animal', passando um id como parâmetro")
    public Animal listaAnimalUnico(@PathVariable(value = "id") long id) {
        return animalRepository.findById(id);
    }

    @PostMapping("/animal")
    @ApiOperation(value = "Salva um 'Animal'")
    public Animal salvaAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @DeleteMapping("/animal")
    @ApiOperation(value = "Deleta um 'Animal'")
    public void deletaAnimal(@RequestBody Animal animal) {
        animalRepository.delete(animal);
    }

    @PutMapping("/animal")
    @ApiOperation(value = "Atualiza um 'Animal'")
    public Animal atualizaAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
}
