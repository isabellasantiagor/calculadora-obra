package com.isabella.calculadora_obra.dto;

public class ResultadoResponse {

    private double resultado;

    public ResultadoResponse(double resultado) {
        this.resultado = resultado;
    }

    public double getResultado() {
        return resultado;
    }
}
