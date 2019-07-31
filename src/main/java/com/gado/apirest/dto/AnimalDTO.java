package com.gado.apirest.dto;

import com.gado.apirest.model.AnimalTipo;
import com.gado.apirest.model.Lote;
import com.gado.apirest.model.Terreno;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AnimalDTO {

    private Long id;
    private Date criacao;
    private Date alteracao;
    private String codigo;
    private String nome;
    private String link;
    private String sexo;
    private Date nascimento;
    private BigDecimal valor_compra;
    private BigDecimal valor_venda;
    private Lote lote;
    private AnimalTipo animalTipo;
    private Terreno terreno;
}
