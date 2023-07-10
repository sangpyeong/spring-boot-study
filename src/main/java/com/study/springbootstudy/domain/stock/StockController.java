package com.study.springbootstudy.domain.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping("/stock/add")
    public Stock addStock(Stock stock) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(stock);
        System.out.println(json);
        stockService.create(stock);
        return stock;
    }

    @GetMapping("/stocks")
    public List<Stock> stocks(){
        return stockService.findAll();
    }

    @GetMapping("/stock/{stockId}")
    public Stock stock(@PathVariable Long stockId){
        return stockService.findById(stockId);
    }

    @GetMapping("/stock/{stockId}/edit")
    public Stock oldStock(@PathVariable Long stockId){
        return stockService.findById(stockId);
    }
    @PostMapping("/stock/{stockId}/edit")
    public String newStock(@PathVariable Long stockId, Stock stock){
        stockService.update(stockId, stock);
        return "redirect:stock/" + stockId;
    }

}
