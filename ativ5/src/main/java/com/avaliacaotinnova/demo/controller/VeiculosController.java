package com.avaliacaotinnova.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Operation(summary = "Criar um veículo", description = "Cria um novo veículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Veículo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar o veículo")
    })
    @PostMapping
    public ResponseEntity<Veiculos> criarUsuario(@RequestBody Veiculos veiculo) {
        Veiculos novoVeiculo = veiculosService.cadastroVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    // @Operation(summary = "Buscar todos os veículos", description = "Retorna todos os veículos")
    // @ApiResponses(value = {
    //         @ApiResponse(responseCode = "200", description = "Retorna todos os veículos"),
    //         @ApiResponse(responseCode = "400", description = "Não há veículos cadastrados")
    // })
    // @GetMapping
    // public List<Veiculos> buscarVeiculos(){
    //     return veiculosService.buscarTodosVeiculos();
    // }

    @Operation(summary = "Buscar o veículo pelo id", description = "Retorna o veículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o veículo"),
            @ApiResponse(responseCode = "400", description = "Não há veículo cadastrado")
    })
    @GetMapping(value = "/{id}")
    public Veiculos buscarVeiculoPorId(@PathVariable("id") Long id){
        return veiculosService.buscarPorId(id);
    }

    @Operation(summary = "Buscar o veículo pela marca, ano, cor", description = "Retorna o veículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o veículo"),
            @ApiResponse(responseCode = "400", description = "Não há veículo cadastrado")
    })
    @GetMapping
    public List<Veiculos> buscarVeiculoPeloParam(@RequestParam(required = false) String marca,
        @RequestParam(required = false) Integer ano,
        @RequestParam(required = false) String cor) {
        return veiculosService.buscarPorParam(marca, ano, cor);
    }

  
    @Operation(summary = "Atualizar um veículo existente", description = "Atualiza um veículo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veículo atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar o veículo")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Veiculos> atualizarVeiculo(@PathVariable long id,@RequestBody Veiculos veiculo) {
        Veiculos atualizadoVeiculo = veiculosService.atualizarVeiculo(veiculo, id);
        return ResponseEntity.ok().body(atualizadoVeiculo);
    }

    @Operation(summary = "Atualizar alguns campos do veículo existente", description = "Atualiza alguns campos do veículo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veículo atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar o veículo")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Veiculos> atualizarAlgunsCamposVeiculo(@PathVariable long id,@RequestBody Map<String, Object> veiculo) {
        Veiculos atualizadoVeiculo = veiculosService.atualizarVeiculoPatch(veiculo, id);
        return ResponseEntity.ok().body(atualizadoVeiculo);
    }


    @Operation(summary = "Excluir um veículo por ID", description = "Exclui um veículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Veículo excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable long id) {
        veiculosService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
