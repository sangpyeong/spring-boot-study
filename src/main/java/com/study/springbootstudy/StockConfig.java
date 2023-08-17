package com.study.springbootstudy;

import com.study.springbootstudy.domain.stock.MemoryStockRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.study.springbootstudy.domain.stock",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = MemoryStockRepository.class
                )
        }
)
public class StockConfig {
}
