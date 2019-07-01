package com.gado.apirest.controller;

import com.gado.apirest.model.Animal;
import com.gado.apirest.repository.AnimalRepository;
import com.gado.apirest.service.AnimalService;
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
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired private AnimalService animalService;


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

    @GetMapping("/animais/resumo")
    @ApiOperation(value = "Retorna uma lista de 'Animais'")
    public Map listaResumoAnimais() {
        return animalService.resumoAnimais();
    }
}
