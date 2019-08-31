package com.gado.apirest.controller;

import com.gado.apirest.dto.AnimalBuilder;
import com.gado.apirest.dto.AnimalDTO;
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
    @Autowired private AnimalBuilder animalBuilder;


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
    public Animal salvaAnimal(@RequestBody AnimalDTO animalDTO) {
        Animal animal = animalBuilder.build(animalDTO);
        return animalRepository.save(animal);
    }

    @PutMapping("/animal/{id}")
    @ApiOperation(value = "Atualiza um 'Animal'")
    public Animal atualizaAnimal(@PathVariable("id") Animal animal, @RequestBody AnimalDTO animalDTO) {
        animalBuilder.build(animal, animalDTO);
        return animalRepository.save(animal);
    }

    @DeleteMapping("/animal/{id}")
    @ApiOperation(value = "Deleta um 'Animal'")
    public void deletaAnimal(@PathVariable("id") Animal animal) {
        animalRepository.delete(animal);
    }

    @GetMapping("/animais/resumo")
    @ApiOperation(value = "Retorna uma lista de 'Animais'")
    public Map listaResumoAnimais() {
        return animalService.resumoAnimais();
    }
}
