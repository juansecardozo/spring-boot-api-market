package com.example.market.web.controllers;

import com.example.market.domain.Sale;
import com.example.market.domain.service.SaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAll() {
        return new ResponseEntity<>(saleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<Sale>> getByCustomer(@PathVariable final String customerId) {
        return saleService.getByCustomer(customerId)
                .map(sales -> new ResponseEntity<>(sales, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody final Sale sale) {
        return new ResponseEntity<>(saleService.save(sale), HttpStatus.CREATED);
    }

}
