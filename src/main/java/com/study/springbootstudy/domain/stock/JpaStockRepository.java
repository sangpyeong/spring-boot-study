package com.study.springbootstudy.domain.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT s FROM Stock s WHERE s.stockName = :stockName")
    Stock findByName(String stockName);
    @Query("UPDATE Stock s SET s.stockName = :stockName, " +
            "s.currentPrice = :currentPrice, " +
            "s.tradingVolume = :tradingVolume, " +
            "s.marketCapitalization = :marketCapitalization " +
            "WHERE s.id = :stockId")
    void update(
            Long stockId,
            String stockName,
            Double currentPrice,
            Long tradingVolume,
            Double marketCapitalization
    );
}
