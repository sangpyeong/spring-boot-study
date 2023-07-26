package com.study.springbootstudy.domain.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    //public StockService(StockRepository stockRepository){ this.stockRepository = stockRepository;}

    public Long create(Stock stock){
        stockRepository.save(stock);
        return stock.getId();
    }

    public Stock findById(Long stockId){
        return stockRepository.findById(stockId);
    }

    public Stock findByName(String stockName){
        return stockRepository.findByName(stockName);
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }

    public Stock update(Long stockId, Stock updateStock){
        stockRepository.update(stockId, updateStock);
        return stockRepository.findById(stockId);
    }

    public void delete(Long stockId){
        stockRepository.delete(stockId);
    }
}
