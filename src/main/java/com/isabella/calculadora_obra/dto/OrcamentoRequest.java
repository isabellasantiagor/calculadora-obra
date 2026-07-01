package com.isabella.calculadora_obra.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class OrcamentoRequest {

    @NotBlank(message = "Informe o nome do cliente")
    private String nomeCliente;

    @NotEmpty(message = "Informe as paredes da planta")
    @Valid
    private List<ArestaRequest> arestas;

    @Positive
    private double altura;

    @Positive
    private double alturaTijolo;

    @Positive
    private double larguraTijolo;

    @Positive
    private double comprimentoTijolo;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ArestaRequest> getArestas() {
        return arestas;
    }

    public void setArestas(List<ArestaRequest> arestas) {
        this.arestas = arestas;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAlturaTijolo() {
        return alturaTijolo;
    }

    public void setAlturaTijolo(double alturaTijolo) {
        this.alturaTijolo = alturaTijolo;
    }

    public double getLarguraTijolo() {
        return larguraTijolo;
    }

    public void setLarguraTijolo(double larguraTijolo) {
        this.larguraTijolo = larguraTijolo;
    }

    public double getComprimentoTijolo() {
        return comprimentoTijolo;
    }

    public void setComprimentoTijolo(double comprimentoTijolo) {
        this.comprimentoTijolo = comprimentoTijolo;
    }
}