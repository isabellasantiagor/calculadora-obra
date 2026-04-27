package com.isabella.calculadora_obra.controller;

import com.isabella.calculadora_obra.dto.ConcretoRequest;
import com.isabella.calculadora_obra.dto.ResultadoResponse;
import com.isabella.calculadora_obra.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.isabella.calculadora_obra.dto.TijoloRequest;

@RestController
@RequestMapping("/api/materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/concreto")
    public ResultadoResponse calcularConcreto(@RequestBody @Valid ConcretoRequest request) {
        double resultado = materialService.calcularVolumeConcreto(request);
        return new ResultadoResponse(resultado);
    }

    @PostMapping("/tijolos")
    public ResultadoResponse calcularTijolos(@RequestBody @Valid TijoloRequest request) {
        double resultado = materialService.calcularQuantidadeTijolos(request);
        return new ResultadoResponse(resultado);
    }
}
