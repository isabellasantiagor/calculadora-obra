package com.isabella.calculadora_obra.service;
import com.isabella.calculadora_obra.dto.TijoloRequest;
import com.isabella.calculadora_obra.dto.ArestaRequest;
import com.isabella.calculadora_obra.dto.ConcretoRequest;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    public double calcularVolumeConcreto(ConcretoRequest request) {
        double volumeTotal = 0;

        for (ArestaRequest aresta : request.getArestas()) {
            double volumeAresta = aresta.getLargura() * request.getAltura() * aresta.getComprimento();
            volumeTotal += volumeAresta;
        }

        return volumeTotal;
    }
    // Cálculo Tijolos
    public double calcularQuantidadeTijolos(TijoloRequest request) {
        double areaTotalParedes = 0;

        for (ArestaRequest aresta : request.getArestas()) {
            double area = aresta.getLargura() * aresta.getComprimento();
            areaTotalParedes += area;
        }

        double areaTijolo = request.getAlturaTijolo() * request.getComprimentoTijolo();

        return areaTotalParedes / areaTijolo;
    }
}
