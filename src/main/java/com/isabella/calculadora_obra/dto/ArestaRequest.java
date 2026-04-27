package com.isabella.calculadora_obra.dto;

import jakarta.validation.constraints.Positive;

public class ArestaRequest {

    @Positive(message = "A largura deve ser maior que zero")
    private double largura;

    @Positive(message = "O comprimento deve ser maior que zero")
    private double comprimento;

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
}
