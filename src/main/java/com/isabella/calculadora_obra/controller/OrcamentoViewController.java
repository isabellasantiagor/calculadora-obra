package com.isabella.calculadora_obra.controller;

import com.isabella.calculadora_obra.dto.OrcamentoRequest;
import com.isabella.calculadora_obra.dto.OrcamentoResponse;
import com.isabella.calculadora_obra.service.OrcamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoViewController {

    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping("/novo")
    public String formularioNovo(Model model) {
        model.addAttribute("orcamentoRequest", new OrcamentoRequest());
        return "orcamento-form";
    }

    @PostMapping
    public String criarOrcamento(@Valid @ModelAttribute("orcamentoRequest") OrcamentoRequest orcamentoRequest,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "orcamento-form";
        }
        OrcamentoResponse resultado = orcamentoService.gerarOrcamento(orcamentoRequest);
        model.addAttribute("orcamento", resultado);
        return "orcamento-resultado";
    }

    @GetMapping("/buscar")
    public String formularioBusca() {
        return "orcamento-busca";
    }

    @GetMapping("/buscar/numero")
    public String buscarPorNumero(@RequestParam Long numero, Model model) {
        try {
            model.addAttribute("orcamento", orcamentoService.buscarPorNumero(numero));
            return "orcamento-resultado";
        } catch (NoSuchElementException e) {
            model.addAttribute("erro", e.getMessage());
            return "orcamento-busca";
        }
    }

    @GetMapping("/buscar/nome")
    public String buscarPorNome(@RequestParam String nome, Model model) {
        List<OrcamentoResponse> resultados = orcamentoService.buscarPorNome(nome);
        if (resultados.isEmpty()) {
            model.addAttribute("erro", "Nenhum orçamento encontrado para \"" + nome + "\"");
            return "orcamento-busca";
        }
        model.addAttribute("resultados", resultados);
        return "orcamento-lista";
    }
}