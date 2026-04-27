package com.isabella.calculadora_obra.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class ConcretoRequest {

    @NotEmpty(message = "A lista de arestas não pode estar vazia")
    @Valid
    private List<ArestaRequest> arestas;

    @Positive(message = "A altura deve ser maior que zero")
    private double altura;

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
}
