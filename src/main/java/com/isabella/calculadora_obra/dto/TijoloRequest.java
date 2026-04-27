package com.isabella.calculadora_obra.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class TijoloRequest {

    @NotEmpty
    @Valid
    private List<ArestaRequest> arestas;

    @Positive
    private double alturaTijolo;

    @Positive
    private double larguraTijolo;

    @Positive
    private double comprimentoTijolo;

    public List<ArestaRequest> getArestas() {
        return arestas;
    }

    public void setArestas(List<ArestaRequest> arestas) {
        this.arestas = arestas;
    }

    public double getAlturaTijolo() {
        return alturaTijolo;
    }

    public void setAlturaTijolo(double alturaTijolo) {
        this.alturaTijolo = alturaTijolo;
    }

    public double getComprimentoTijolo() {
        return comprimentoTijolo;
    }

    public void setComprimentoTijolo(double comprimentoTijolo) {
        this.comprimentoTijolo = comprimentoTijolo;
    }

    public double getLarguraTijolo() {
        return larguraTijolo;
    }

    public void setLarguraTijolo(double larguraTijolo) {
        this.larguraTijolo = larguraTijolo;
    }
}
