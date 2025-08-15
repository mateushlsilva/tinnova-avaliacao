package com.avaliacaotinnova.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.avaliacaotinnova.demo.entity.Veiculos;
import com.avaliacaotinnova.demo.enums.Marca;
import com.avaliacaotinnova.demo.repository.VeiculosRepository;

@Service
public class VeiculosService {
    @Autowired
    private VeiculosRepository veiculosRep;

    public Veiculos cadastroVeiculo(Veiculos veiculo) {
        if (veiculo == null ||
                veiculo.getDescricao() == null ||
                veiculo.getDescricao().isBlank() ||
                veiculo.getVeiculo() == null ||
                veiculo.getVeiculo().isBlank() ||
                veiculo.getMarca() == null ||
                veiculo.getMarca().isBlank() ||
                veiculo.getCor() == null ||
                veiculo.getCor().isBlank() ||
                veiculo.getAno() == null ||
                veiculo.getVendido() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        try {
            Marca.valueOf(veiculo.getMarca().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Marca inválida: " + veiculo.getMarca());
        }
        if (veiculo.getCreated() == null || veiculo.getUpdated() == null) {
            veiculo.setCreated(LocalDateTime.now());
            veiculo.setUpdated(LocalDateTime.now());
        }
        return veiculosRep.save(veiculo);
    }

    public List<Veiculos> buscarTodosVeiculos() {
        List<Veiculos> veiculos = veiculosRep.findAll();
        return veiculos;
    }

    public Veiculos buscarPorId(Long id) {
        Optional<Veiculos> veiculo = veiculosRep.findById(id);
        if (veiculo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!");
        }
        return veiculo.get();
    }


    public List<Veiculos> buscarPorParam(String marca, Integer ano, String cor){
        Integer decadaStart = null;
        Integer decadaEnd = null;

        if (ano != null) {
            decadaStart = (ano / 10) * 10; 
            decadaEnd = decadaStart + 9; 
        }
        return veiculosRep.findByFiltros(marca, decadaStart, decadaEnd, cor);
    }

    public Veiculos atualizarVeiculo(Veiculos veiculo, Long id) {
        Veiculos veiculoOp = veiculosRep.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));

        try {
            Marca.valueOf(veiculo.getMarca().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Marca inválida: " + veiculo.getMarca());
        }
        if (veiculo == null ||
                veiculo.getDescricao() == null ||
                veiculo.getDescricao().isBlank() ||
                veiculo.getVeiculo() == null ||
                veiculo.getVeiculo().isBlank() ||
                veiculo.getMarca() == null ||
                veiculo.getMarca().isBlank() ||
                veiculo.getCor() == null ||
                veiculo.getCor().isBlank() ||
                veiculo.getAno() == null ||
                veiculo.getVendido() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        veiculo.setCreated(veiculoOp.getCreated());
        veiculo.setId(id);
        veiculo.setUpdated(LocalDateTime.now());
        return veiculosRep.save(veiculo);
    }

    public void atualizaSeNaoNulo(Map<String, Object> valores, Veiculos veiculo) {
        valores.forEach((chave, valor) -> {
            switch (chave) {
                case "marca" -> {
                    String marcaStr = (String) valor;
                    try {
                        Marca.valueOf(marcaStr.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Marca inválida: " + marcaStr);
                    }
                    veiculo.setMarca((String) valor);
                }
                case "descricao" -> veiculo.setDescricao((String) valor);
                case "veiculo" -> veiculo.setVeiculo((String) valor);
                case "cor" -> veiculo.setCor((String) valor);
                case "ano" -> veiculo.setAno((Integer) valor);
                case "vendido" -> veiculo.setVendido((Boolean) valor);
            }
        });
    }

    public Veiculos atualizarVeiculoPatch(Map<String, Object> veiculo, Long id) {

        Veiculos veiculoOp = veiculosRep.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));

        veiculoOp.setUpdated(LocalDateTime.now());
        atualizaSeNaoNulo(veiculo, veiculoOp);
        return veiculosRep.save(veiculoOp);
    }

    public void deletarPorId(Long id) {
        veiculosRep.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));
        veiculosRep.deleteById(id);
    }
}
