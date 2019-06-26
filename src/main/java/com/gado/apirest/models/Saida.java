package com.gado.apirest.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_saida")
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Long id_gasto;

    private String observacao;

    private BigDecimal valor;

    private Long id_usuario;

    @PrePersist
    @PreUpdate
    private void dataAutomatica(){
        this.criacao = new Date();
    }
}
