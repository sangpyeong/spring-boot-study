package com.study.springbootstudy.domain.stock;

import java.util.List;

public interface StockRepository {
    Stock save(Stock stock);
    Stock findById(Long id);
    Stock findByName(String name);
    List<Stock> findAll();
    void update(long stockId, Stock updateParam);
    void delete(long stockId);
    void clearStore();
}
