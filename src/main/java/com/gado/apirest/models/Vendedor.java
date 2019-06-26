package com.gado.apirest.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_vendedor")
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private String nome;

    private BigDecimal celular;

    @PrePersist
    @PreUpdate
    private void dataAutomatica(){
        this.criacao = new Date();
    }
}
