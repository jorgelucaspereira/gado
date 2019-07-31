package com.gado.apirest.service;

import com.gado.apirest.model.Animal;
import com.gado.apirest.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Map resumoAnimais(){
        List<Animal> animais = animalRepository.findAll();
         Map resumoAnimais = new HashMap();

        List<Animal> machos = animais.stream().filter(a -> a.getSexo().equals("Macho")).collect(Collectors.toList());
        List<Animal> femeas = animais.stream().filter(a -> a.getSexo().equals("Fêmea")).collect(Collectors.toList());
        BigDecimal total = animais.stream().map(item -> item.getValor_compra()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        resumoAnimais.put("animaisMachos", machos);
        resumoAnimais.put("animaisFemea", femeas);
        resumoAnimais.put("qntMacho", machos.size());
        resumoAnimais.put("qntFemea", femeas.size());
        resumoAnimais.put("totalAnimais", animais.size());
        resumoAnimais.put("totalGasto", total);

        return resumoAnimais;
    }

}
