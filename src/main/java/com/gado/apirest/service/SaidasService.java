package com.gado.apirest.service;

import com.gado.apirest.model.Gasto;
import com.gado.apirest.model.Saida;
import com.gado.apirest.repository.GastoRepository;
import com.gado.apirest.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaidasService {

    @Autowired
    private SaidaRepository saidaRepository;

    @Autowired
    private GastoRepository gastoRepository;

    public List<Saida> buscarSaidasPorGasto(Gasto gasto) {
        return saidaRepository.findAllByGasto(gasto);
    }

    public Saida salvar(Saida saida) {
        if (saida.getGasto() != null) {
            Gasto gasto = saida.getGasto();

            List<Saida> saidas = saidaRepository.findAllByGasto(gasto);

            BigDecimal totalSaidasGasto = saidas.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

            if (totalSaidasGasto.compareTo(gasto.getValor()) >= 0) {
                gasto.setPago(true);
                gastoRepository.save(gasto);
            }
        }
        return saidaRepository.save(saida);
    }

    public Map resumoSaidas() {
        List<Saida> saidas = saidaRepository.findAll();
        Map resumoSaida = new HashMap();

        BigDecimal total = saidas.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        resumoSaida.put("totalSaida", total);

        return resumoSaida;
    }
}
