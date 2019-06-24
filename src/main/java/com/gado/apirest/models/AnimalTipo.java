package com.gado.apirest.models;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd_meses_venda() {
        return qtd_meses_venda;
    }

    public void setQtd_meses_venda(Integer qtd_meses_venda) {
        this.qtd_meses_venda = qtd_meses_venda;
    }

    public Integer getQtd_por_hectare() {
        return qtd_por_hectare;
    }

    public void setQtd_por_hectare(Integer qtd_por_hectare) {
        this.qtd_por_hectare = qtd_por_hectare;
    }
}
