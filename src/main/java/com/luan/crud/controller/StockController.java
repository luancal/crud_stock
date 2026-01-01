package com.luan.crud.controller;

import com.luan.crud.entities.Stock;
import com.luan.crud.services.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    public StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> create(@Valid @RequestBody Stock stock) {
        Stock stockSaved = stockService.sumItem(stock);
        return new ResponseEntity<>(stockSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> stockTotal() {
        List<Stock> items = stockService.stockTotal();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Stock> getItemId(@PathVariable Long id) {
        Stock byId = stockService.getId(id);
        return ResponseEntity.ok(byId);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateId(@RequestBody Stock stock, @PathVariable Long id) {
        stockService.updateStock(stock, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Long id) {
        stockService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }


}
