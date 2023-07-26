package com.study.springbootstudy.domain.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryStockRepository implements StockRepository {

    private static final Map<Long, Stock> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Stock save(Stock stock) {
        stock.setId(++sequence);
        store.put(stock.getId(), stock);
        return stock;
    }

    @Override
    public Stock findById(Long id) {
        return store.get(id);
    }

    @Override
    public Stock findByName(String name) {
        return store.get(name);
    }

    @Override
    public List<Stock> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(long stockId, Stock updateParam) {
        Stock findStock = findById(stockId);
        findStock.setStockName(updateParam.getStockName());
        findStock.setCurrentPrice(updateParam.getCurrentPrice());
        findStock.setTradingVolume(updateParam.getTradingVolume());
        findStock.setMarketCapitalization(updateParam.getMarketCapitalization());
    }

    @Override
    public void delete(long stockId) {
        store.remove(stockId);
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
