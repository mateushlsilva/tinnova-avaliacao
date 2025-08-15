package com.avaliacaotinnova.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.avaliacaotinnova.demo.entity.Veiculos;
import com.avaliacaotinnova.demo.repository.VeiculosRepository;

@Service
public class VeiculosService {
    @Autowired
    private VeiculosRepository veiculosRep;

    public Veiculos cadastroVeiculo(Veiculos veiculo){
        if(veiculo == null || 
            veiculo.getDescricao() == null ||
            veiculo.getDescricao().isBlank() || 
            veiculo.getVeiculo() == null ||
            veiculo.getVeiculo().isBlank() ||
            veiculo.getMarca() == null ||
            veiculo.getMarca().isBlank() ||
            veiculo.getAno() == null ||
            veiculo.getVendido() == null
        ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return veiculosRep.save(veiculo) ;
    }
}
