package com.gado.apirest.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_animal")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private String codigo;

    private String nome;

    private String sexo;

    private Date nascimento;

    private BigDecimal valor_compra;

    private BigDecimal valor_venda;

    private Long id_lote;

    private Long id_animal_tipo;

    private Long id_terreno;

    @PrePersist
    @PreUpdate
    private void dataAutomatica(){
        this.criacao = new Date();
    }
}
