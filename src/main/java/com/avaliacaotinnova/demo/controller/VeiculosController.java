package com.avaliacaotinnova.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacaotinnova.demo.entity.Veiculos;
import com.avaliacaotinnova.demo.service.VeiculosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/veiculos")
@CrossOrigin
@Tag(name = "Veiculos")
public class VeiculosController {
    @Autowired
    private VeiculosService veiculosService;

    @Operation(summary = "Criar um veiculo", description = "Cria um novo veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Veiculo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar o veiculo")
    })
    @PostMapping
    public ResponseEntity<Veiculos> criarUsuario(@RequestBody Veiculos veiculo) {
        Veiculos novoVeiculo = veiculosService.cadastroVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }
}
