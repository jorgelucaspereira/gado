package com.gado.apirest.models;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private BigDecimal quantidade;

    private BigDecimal qtd_minimo;

    private BigDecimal qtd_maximo;

    private Long id_produto;

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

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQtd_minimo() {
        return qtd_minimo;
    }

    public void setQtd_minimo(BigDecimal qtd_minimo) {
        this.qtd_minimo = qtd_minimo;
    }

    public BigDecimal getQtd_maximo() {
        return qtd_maximo;
    }

    public void setQtd_maximo(BigDecimal qtd_maximo) {
        this.qtd_maximo = qtd_maximo;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }
}
