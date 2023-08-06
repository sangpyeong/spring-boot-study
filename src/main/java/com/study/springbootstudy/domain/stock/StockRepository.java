package com.study.springbootstudy.domain.stock;

import java.util.List;
import java.util.Optional;

public interface StockRepository {
    Stock save(Stock stock);
    Optional<Stock> findById(Long id);
    Stock findByName(String name);
    List<Stock> findAll();
    void update(long stockId, Stock updateParam);
    void deleteById(long stockId);
}
