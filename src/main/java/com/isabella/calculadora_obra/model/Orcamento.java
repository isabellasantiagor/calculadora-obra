package com.isabella.calculadora_obra.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orcamentos")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private double volumeConcreto;
    private double quantidadeTijolos;

    private double altura;
    private double alturaTijolo;
    private double larguraTijolo;
    private double comprimentoTijolo;

    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parede> paredes = new ArrayList<>();

    public Orcamento() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public double getVolumeConcreto() { return volumeConcreto; }
    public void setVolumeConcreto(double volumeConcreto) { this.volumeConcreto = volumeConcreto; }

    public double getQuantidadeTijolos() { return quantidadeTijolos; }
    public void setQuantidadeTijolos(double quantidadeTijolos) { this.quantidadeTijolos = quantidadeTijolos; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getAlturaTijolo() { return alturaTijolo; }
    public void setAlturaTijolo(double alturaTijolo) { this.alturaTijolo = alturaTijolo; }

    public double getLarguraTijolo() { return larguraTijolo; }
    public void setLarguraTijolo(double larguraTijolo) { this.larguraTijolo = larguraTijolo; }

    public double getComprimentoTijolo() { return comprimentoTijolo; }
    public void setComprimentoTijolo(double comprimentoTijolo) { this.comprimentoTijolo = comprimentoTijolo; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }

    public List<Parede> getParedes() { return paredes; }
    public void setParedes(List<Parede> paredes) { this.paredes = paredes; }

    public void adicionarParede(Parede parede) {
        parede.setOrcamento(this);
        this.paredes.add(parede);
    }
}