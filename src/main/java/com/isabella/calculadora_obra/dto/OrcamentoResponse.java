package com.isabella.calculadora_obra.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrcamentoResponse {

    private Long numeroOrcamento;
    private String nomeCliente;
    private double volumeConcreto;
    private double quantidadeTijolos;
    private double altura;
    private LocalDateTime dataCriacao;
    private List<ArestaRequest> paredes;

    public OrcamentoResponse(Long numeroOrcamento, String nomeCliente,
                             double volumeConcreto, double quantidadeTijolos,
                             double altura, LocalDateTime dataCriacao,
                             List<ArestaRequest> paredes) {
        this.numeroOrcamento = numeroOrcamento;
        this.nomeCliente = nomeCliente;
        this.volumeConcreto = volumeConcreto;
        this.quantidadeTijolos = quantidadeTijolos;
        this.altura = altura;
        this.dataCriacao = dataCriacao;
        this.paredes = paredes;
    }

    public Long getNumeroOrcamento() { return numeroOrcamento; }
    public String getNomeCliente() { return nomeCliente; }
    public double getVolumeConcreto() { return volumeConcreto; }
    public double getQuantidadeTijolos() { return quantidadeTijolos; }
    public double getAltura() { return altura; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public List<ArestaRequest> getParedes() { return paredes; }
}