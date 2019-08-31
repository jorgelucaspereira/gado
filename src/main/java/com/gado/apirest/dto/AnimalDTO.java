package com.gado.apirest.dto;

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
    private long idLote;
    private long idAnimalTipo;
    private long idTerreno;
}
