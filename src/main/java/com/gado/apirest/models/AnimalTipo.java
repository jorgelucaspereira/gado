package com.gado.apirest.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_animal_tipo")
public class AnimalTipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private String nome;

    private Integer qtd_meses_venda;

    private Integer qtd_por_hectare;

    @PrePersist
    @PreUpdate
    private void dataAutomatica(){
        this.criacao = new Date();
    }
}
