package com.avaliacaotinnova.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

    public Veiculos cadastroVeiculo(Veiculos veiculo) {
        if (veiculo == null ||
                veiculo.getDescricao() == null ||
                veiculo.getDescricao().isBlank() ||
                veiculo.getVeiculo() == null ||
                veiculo.getVeiculo().isBlank() ||
                veiculo.getMarca() == null ||
                veiculo.getMarca().isBlank() ||
                veiculo.getAno() == null ||
                veiculo.getVendido() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
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

    public Veiculos atualizarVeiculo(Veiculos veiculo, Long id) {
        Veiculos veiculoOp = veiculosRep.findById(id) 
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));
       
            if (veiculo == null ||
                    veiculo.getDescricao() == null ||
                    veiculo.getDescricao().isBlank() ||
                    veiculo.getVeiculo() == null ||
                    veiculo.getVeiculo().isBlank() ||
                    veiculo.getMarca() == null ||
                    veiculo.getMarca().isBlank() ||
                    veiculo.getAno() == null ||
                    veiculo.getVendido() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
            }
            veiculo.setCreated(veiculoOp.getCreated());
            veiculo.setId(id);
            veiculo.setUpdated(LocalDateTime.now());
            return veiculosRep.save(veiculo);
    }
    public <T> void atualizaSeNaoNulo(T valor, Consumer<T> setter) {
        if (valor != null) {
            setter.accept(valor);
        }
    }
    public Veiculos atualizarVeiculoPatch(Veiculos veiculo, Long id) {
        
        Veiculos veiculoOp = veiculosRep.findById(id) 
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));
        
        atualizaSeNaoNulo(veiculo.getMarca(), veiculoOp::setMarca);
        atualizaSeNaoNulo(veiculo.getDescricao(), veiculoOp::setDescricao);
        atualizaSeNaoNulo(veiculo.getVeiculo(), veiculoOp::setVeiculo);
        atualizaSeNaoNulo(veiculo.getAno(), veiculoOp::setAno);
        atualizaSeNaoNulo(veiculo.getVendido(), veiculoOp::setVendido);
      
           
        veiculo.setCreated(veiculoOp.getCreated());
        veiculo.setId(id);
        veiculo.setUpdated(LocalDateTime.now());
        return veiculosRep.save(veiculo);
    }

    public void deletarPorId(Long id){
        veiculosRep.findById(id) 
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado!"));
        veiculosRep.deleteById(id);
    }
}
