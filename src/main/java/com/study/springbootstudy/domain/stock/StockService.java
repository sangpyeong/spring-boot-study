package com.study.springbootstudy.domain.stock;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    @Transactional
    public Long create(Stock stock){
        stockRepository.save(stock);
        return stock.getId();
    }
    @Transactional
    public Stock findById(Long stockId){
        return stockRepository.findById(stockId).orElse(null);
    }
    @Transactional
    public Stock findByName(String stockName){
        return stockRepository.findByName(stockName);
    }
    @Transactional
    public List<Stock> findAll(){
        return stockRepository.findAll();
    }
    @Transactional
    public Stock update(Long stockId, Stock updateStock){
        Stock existingStock = stockRepository.findById(stockId).orElse(null);
        if (existingStock != null) {
            existingStock.setStockName(updateStock.getStockName());
            existingStock.setCurrentPrice(updateStock.getCurrentPrice());
            existingStock.setTradingVolume(updateStock.getTradingVolume());
            existingStock.setMarketCapitalization(updateStock.getMarketCapitalization());
            return stockRepository.save(existingStock);
        }
        return null;
    }
    @Transactional
    public void delete(Long stockId){
        stockRepository.deleteById(stockId);
    }
}
