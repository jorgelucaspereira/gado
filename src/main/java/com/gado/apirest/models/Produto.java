package com.gado.apirest.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private String nome;

    private String descricao;

    private String marca;

    private BigDecimal peso;

    private BigDecimal valor;

    private BigDecimal duracao_meses;

    @PrePersist
    @PreUpdate
    private void dataAutomatica(){
        this.criacao = new Date();
    }
}
