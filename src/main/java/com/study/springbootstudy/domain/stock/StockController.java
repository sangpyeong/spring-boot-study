package com.study.springbootstudy.domain.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StockController {
    private final StockService stockService;

    @PostMapping("/stock/add")
    public String addStock(@RequestBody Stock stock) throws JsonProcessingException {
        stockService.create(stock);
        return "redirect:/stocks";
    }


    @GetMapping("/stocks")
    public List<Stock> stocks(){
        return stockService.findAll();
    }

    @GetMapping("/stock/{stockId}")
    public Stock stock(@PathVariable Long stockId){
        return stockService.findById(stockId);
    }

    @PostMapping("/stock/{stockId}/edit")
    public String newStock(@PathVariable Long stockId,@RequestBody Stock stock) throws JsonProcessingException {
        stockService.update(stockId, stock);
        return "redirect:/stocks";
    }
    @PostMapping("/stocks/delete")
    public void delete(@RequestBody List<Long> ids){
        for(Long id:ids){
            stockService.delete(id);
        }
    }
}
