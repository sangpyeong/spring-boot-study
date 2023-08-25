package com.study.springbootstudy.domain.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public Optional<Stock> findById(Long id) {
        Optional<Stock> optionalStock = Optional.ofNullable(store.get(id));
        return optionalStock;
    }

    @Override
    public Stock findByName(String name) {
        return store.values().stream()
                .filter(stock -> name.equals(stock.getStockName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Stock> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(long stockId, Stock updateParam) {
        Optional<Stock> optionalStock = findById(stockId);

        optionalStock.ifPresent(findStock -> {
            findStock.setStockName(updateParam.getStockName());
            findStock.setCurrentPrice(updateParam.getCurrentPrice());
            findStock.setTradingVolume(updateParam.getTradingVolume());
            findStock.setMarketCapitalization(updateParam.getMarketCapitalization());
        });
    }

    @Override
    public void deleteById(long stockId) {
        store.remove(stockId);
    }


}
