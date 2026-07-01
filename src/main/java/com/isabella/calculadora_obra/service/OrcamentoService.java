package com.isabella.calculadora_obra.service;

import com.isabella.calculadora_obra.dto.ArestaRequest;
import com.isabella.calculadora_obra.dto.ConcretoRequest;
import com.isabella.calculadora_obra.dto.OrcamentoRequest;
import com.isabella.calculadora_obra.dto.OrcamentoResponse;
import com.isabella.calculadora_obra.dto.TijoloRequest;
import com.isabella.calculadora_obra.model.Orcamento;
import com.isabella.calculadora_obra.model.Parede;
import com.isabella.calculadora_obra.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public OrcamentoResponse gerarOrcamento(OrcamentoRequest request) {

        ConcretoRequest concreto = new ConcretoRequest();
        concreto.setAltura(request.getAltura());
        concreto.setArestas(request.getArestas());

        TijoloRequest tijolo = new TijoloRequest();
        tijolo.setArestas(request.getArestas());
        tijolo.setAlturaTijolo(request.getAlturaTijolo());
        tijolo.setLarguraTijolo(request.getLarguraTijolo());
        tijolo.setComprimentoTijolo(request.getComprimentoTijolo());

        double volumeConcreto = materialService.calcularVolumeConcreto(concreto);
        double quantidadeTijolos = materialService.calcularQuantidadeTijolos(tijolo);

        Orcamento orcamento = new Orcamento();
        orcamento.setNomeCliente(request.getNomeCliente());
        orcamento.setVolumeConcreto(volumeConcreto);
        orcamento.setQuantidadeTijolos(quantidadeTijolos);
        orcamento.setAltura(request.getAltura());
        orcamento.setAlturaTijolo(request.getAlturaTijolo());
        orcamento.setLarguraTijolo(request.getLarguraTijolo());
        orcamento.setComprimentoTijolo(request.getComprimentoTijolo());

        for (ArestaRequest aresta : request.getArestas()) {
            orcamento.adicionarParede(new Parede(aresta.getLargura(), aresta.getComprimento()));
        }

        orcamento = orcamentoRepository.save(orcamento);
        return toResponse(orcamento);
    }

    public OrcamentoResponse buscarPorNumero(Long numero) {
        Orcamento orcamento = orcamentoRepository.findById(numero)
                .orElseThrow(() -> new NoSuchElementException(
                        "Orçamento número " + numero + " não encontrado"));
        return toResponse(orcamento);
    }

    public List<OrcamentoResponse> buscarPorNome(String nome) {
        return orcamentoRepository.findByNomeClienteContainingIgnoreCase(nome)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private OrcamentoResponse toResponse(Orcamento orcamento) {
        List<ArestaRequest> paredes = orcamento.getParedes().stream()
                .map(p -> {
                    ArestaRequest a = new ArestaRequest();
                    a.setLargura(p.getLargura());
                    a.setComprimento(p.getComprimento());
                    return a;
                })
                .collect(Collectors.toList());

        return new OrcamentoResponse(
                orcamento.getId(),
                orcamento.getNomeCliente(),
                orcamento.getVolumeConcreto(),
                orcamento.getQuantidadeTijolos(),
                orcamento.getAltura(),
                orcamento.getDataCriacao(),
                paredes
        );
    }
}