package com.isabella.calculadora_obra.repository;

import com.isabella.calculadora_obra.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    List<Orcamento> findByNomeCliente(String nomeCliente);

    List<Orcamento> findByNomeClienteContainingIgnoreCase(String nomeCliente);
}