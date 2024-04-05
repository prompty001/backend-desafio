package com.belibrary.services;

import com.belibrary.dtos.CostumerDto;
import com.belibrary.models.Costumer;
import com.belibrary.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;

    // Cadastra um novo Cliente
    public Costumer createCostumer(CostumerDto costumerData) {
        Costumer newCostumer = new Costumer(costumerData);
        saveCostumer(newCostumer);
        return newCostumer;
    }

    // Faz a persistência do novo Cliente
    public void saveCostumer(Costumer costumer) {
        this.costumerRepository.save(costumer);
    }

    // Lista todos os registros (clientes cadastrados)
    public List<Costumer> getAllCostumers() {
        return this.costumerRepository.findAll();
    }

    // Edita os dados de um determinado cliente
    public Costumer updateCostumer(Long id, CostumerDto costumerData) {
        Costumer updatedCostumer = this.costumerRepository.findById(id).orElseThrow();

        updatedCostumer.setName(costumerData.getName());
        updatedCostumer.setCpf(costumerData.getCpf());
        updatedCostumer.setBirthday(costumerData.getBirthday());

        return this.costumerRepository.save(updatedCostumer);
    }

    // Deleta um determinado cliente
    public void deleteCostumerById(Long id) {
        Optional<Costumer> costumerOptional = this.costumerRepository.findById(id);
        costumerOptional.ifPresent(costumer -> this.costumerRepository.delete(costumer));
    }
}
