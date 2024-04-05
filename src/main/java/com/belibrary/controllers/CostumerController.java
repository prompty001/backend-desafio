package com.belibrary.controllers;

import com.belibrary.dtos.CostumerDto;
import com.belibrary.models.Costumer;
import com.belibrary.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/costumers")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @PostMapping
    public ResponseEntity<Costumer> createCostumer(@RequestBody CostumerDto costumerData) {
        Costumer newCostumer = costumerService.createCostumer(costumerData);

        return new ResponseEntity<>(newCostumer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Costumer>> getAllCostumers() {
        List<Costumer> costumers = costumerService.getAllCostumers();

        return new ResponseEntity<>(costumers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Costumer> updateCostumer(@PathVariable Long id, @RequestBody CostumerDto costumerData) {
        Costumer updateCostumer = costumerService.updateCostumer(id, costumerData);

        return ResponseEntity.ok(updateCostumer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Costumer> deleteCostumer(@PathVariable Long id) {
        costumerService.deleteCostumerById(id);

        return ResponseEntity.noContent().build();
    }
}
