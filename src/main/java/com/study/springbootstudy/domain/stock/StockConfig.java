package com.study.springbootstudy.domain.stock;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

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
