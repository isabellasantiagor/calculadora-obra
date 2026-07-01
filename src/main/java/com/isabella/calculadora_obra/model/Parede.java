package com.isabella.calculadora_obra.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paredes")
public class Parede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double largura;
    private double comprimento;

    @ManyToOne
    @JoinColumn(name = "orcamento_id", nullable = false)
    private Orcamento orcamento;

    public Parede() {
    }

    public Parede(double largura, double comprimento) {
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Long getId() { return id; }

    public double getLargura() { return largura; }
    public void setLargura(double largura) { this.largura = largura; }

    public double getComprimento() { return comprimento; }
    public void setComprimento(double comprimento) { this.comprimento = comprimento; }

    public Orcamento getOrcamento() { return orcamento; }
    public void setOrcamento(Orcamento orcamento) { this.orcamento = orcamento; }
}