package com.magjack.javatechtest.services;

import com.magjack.javatechtest.domain.Adjustment;
import com.magjack.javatechtest.domain.Sale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReportPrinterService {

    @Autowired
    SalesService salesService;

    @Autowired
    AdjustmentService adjustmentService;

    public void reportSales() {

        log.info("Printing product totals log");
        List<Sale> sales = salesService.getSales();

        Map<String, Double> productTotals = sales.stream().collect(Collectors.groupingBy(Sale::getProduct, Collectors.reducing(0.0, Sale::getTotal, Double::sum)));

        log.info(productTotals.toString());
    }

    public void reportAdjustments() {
        log.info("Printing adjustments log");
        List<Adjustment> adjustments = adjustmentService.getAdjustments();

        Map<String, List<Adjustment>> productAdjustments = adjustments.stream()
                .collect(
                        Collectors.groupingBy(
                                Adjustment::getProduct));
        log.info(productAdjustments.toString());

    }


}
