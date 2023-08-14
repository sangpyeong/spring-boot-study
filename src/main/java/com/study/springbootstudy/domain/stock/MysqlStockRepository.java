package com.study.springbootstudy.domain.stock;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MysqlStockRepository implements StockRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Stock save(Stock stock) {
        entityManager.persist(stock);
        return stock;
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Stock.class, id));
    }

    @Override
    public Stock findByName(String name) {
        return entityManager.createQuery("SELECT s FROM Stock s WHERE s.stockName = :name", Stock.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Stock> findAll() {
        return entityManager.createQuery("SELECT s FROM Stock s", Stock.class)
                .getResultList();
    }

    @Override
    public void update(long stockId, Stock updateParam) {
        Stock existingStock = entityManager.find(Stock.class, stockId);
        if (existingStock != null) {
            existingStock.setStockName(updateParam.getStockName());
            existingStock.setCurrentPrice(updateParam.getCurrentPrice());
            existingStock.setTradingVolume(updateParam.getTradingVolume());
            existingStock.setMarketCapitalization(updateParam.getMarketCapitalization());
            entityManager.merge(existingStock);
        }
    }

    @Override
    public void deleteById(long stockId) {
        Stock stock = entityManager.find(Stock.class, stockId);
        if (stock != null) {
            entityManager.remove(stock);
        }
    }
}

