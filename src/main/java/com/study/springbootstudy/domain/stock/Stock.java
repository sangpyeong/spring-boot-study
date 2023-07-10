package com.study.springbootstudy.domain.stock;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Stock{
    private Long id;
    private String stockName;
    private Integer currentPrice;
    private Integer marketCapitalization;
    private Integer tradingVolume;
}
