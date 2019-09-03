package com.magjack.javatechtest.controllers;

import com.magjack.javatechtest.domain.Sale;
import com.magjack.javatechtest.domain.SaleAndAdjustment;
import com.magjack.javatechtest.services.AdjustmentService;
import com.magjack.javatechtest.services.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
@Slf4j
public class MessageController {
    @Autowired
    SalesService salesService;

    @Autowired
    AdjustmentService adjustmentService;

    @PostMapping("/saleAdjust")
    String processSaleAndAdjustment(@RequestBody SaleAndAdjustment saleAndAdjustment){

        log.info(saleAndAdjustment.toString());

        salesService.addSale(saleAndAdjustment.getSale());
        salesService.applyAdjustment(saleAndAdjustment.getAdjustment());
        adjustmentService.addAdjustment(saleAndAdjustment.getAdjustment());


        return "Accepted";
    }

    @PostMapping("/sale")
    String processSale(@RequestBody Sale sale){

        log.info(sale.toString());

        salesService.addSale(sale);

        return "Accepted";
    }


}
