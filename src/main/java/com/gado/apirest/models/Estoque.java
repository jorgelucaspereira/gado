package com.gado.apirest.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Date alteracao;

    private BigDecimal quantidade;

    private BigDecimal qtd_minimo;

    private BigDecimal qtd_maximo;

    private Long id_produto;

    @PrePersist
    private void dataAutomatica(){
        this.criacao = new Date();
    }

    @PreUpdate
    private void dataAtualizada(){
        this.alteracao = new Date();
    }
}
