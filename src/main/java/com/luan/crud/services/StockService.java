package com.luan.crud.services;

import com.luan.crud.entities.Stock;
import com.luan.crud.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock sumItem(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    public void deleteItem(Long id) {
        stockRepository.deleteById(id);
    }

    public Stock getId(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado com este id: " + id));
    }

    public List<Stock> stockTotal() {
        return stockRepository.findAll();
    }

    @Transactional
    public void updateStock(Stock stock, Long id){
        Stock now = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        now.setName(stock.getName());
        now.setPrice(stock.getPrice());
        now.setQuantity(stock.getQuantity());
        stockRepository.save(now);
    }

}
