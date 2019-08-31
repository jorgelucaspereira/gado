package com.gado.apirest.dto;

import com.gado.apirest.model.Animal;
import com.gado.apirest.repository.AnimalTipoRepository;
import com.gado.apirest.repository.LoteRepository;
import com.gado.apirest.repository.TerrenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalBuilder {
    @Autowired
    LoteRepository loteRepository;
    AnimalTipoRepository animalTipoRepository;
    TerrenoRepository terrenoRepository;

    public Animal build(AnimalDTO animalDTO) {
        return build(null, animalDTO);
    }

    public Animal build(Animal animal, AnimalDTO animalDTO) {
        if (animal == null) {
            animal = new Animal();
        }
        animal.setCodigo(animalDTO.getCodigo());
        animal.setNome(animalDTO.getNome());
        animal.setLink(animalDTO.getLink());
        animal.setSexo(animalDTO.getSexo());
        animal.setNascimento(animalDTO.getNascimento());
        animal.setValor_compra(animalDTO.getValor_compra());
        animal.setValor_venda(animalDTO.getValor_venda());
        animal.setLote(loteRepository.findById(animalDTO.getIdLote()));
        animal.setAnimalTipo(animalTipoRepository.findById(animalDTO.getIdAnimalTipo()));
        animal.setTerreno(terrenoRepository.findById(animalDTO.getIdTerreno()));

        return animal;
    }
}
