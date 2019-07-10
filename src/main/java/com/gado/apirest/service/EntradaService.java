package com.gado.apirest.service;

import com.gado.apirest.model.Entrada;
import com.gado.apirest.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public Map resumoEntradas() {
        List<Entrada> entradas = entradaRepository.findAll();
        Map resumoEntrada = new HashMap();

        BigDecimal total = entradas.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        resumoEntrada.put("totalEntrada", total);

        return resumoEntrada;
    }
}
