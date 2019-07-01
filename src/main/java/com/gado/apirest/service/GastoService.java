package com.gado.apirest.service;

import com.gado.apirest.model.Gasto;
import com.gado.apirest.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public Map resumoGastos() {
        List<Gasto> gastos = gastoRepository.findAll();
        Map resumoGasto = new HashMap();

        BigDecimal total = gastos.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        BigDecimal totalPago = gastos.stream().filter(a -> a.getPago().equals(true)).map(item -> item.getValor()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        List<Gasto> pagos = gastos.stream().filter(a -> a.getPago().equals(true)).collect(Collectors.toList());
        List<Gasto> necessarios = gastos.stream().filter(a -> a.getNecessario().equals(true)).collect(Collectors.toList());

        resumoGasto.put("gastosPagos", pagos);
        resumoGasto.put("gastosNecessarios", necessarios);
        resumoGasto.put("qtdGastosPagos", pagos.size());
        resumoGasto.put("qtdGastosNecessarios", necessarios.size());
        resumoGasto.put("totalGasto", total);
        resumoGasto.put("totalPago", totalPago);

        return resumoGasto;
    }
}
