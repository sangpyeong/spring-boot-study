package com.study.springbootstudy.domain.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
@Entity
public class Stock{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stockName;

    @Column(name = "currentPrice")
    private Integer currentPrice;
    private Integer marketCapitalization;
    private Integer tradingVolume;
}
