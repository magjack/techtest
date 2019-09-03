package com.magjack.javatechtest.services;

import com.magjack.javatechtest.domain.Adjustment;
import com.magjack.javatechtest.domain.Sale;
import com.sun.codemodel.internal.JCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    List<Sale> sales;

    public void addSale(Sale newSale){
        sales.add(newSale);
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void applyAdjustment(Adjustment adjustment){

        sales = sales.stream().map( sale -> {
            if(sale.getProduct().equals(adjustment.getProduct())){
                switch(adjustment.getOperation()) {
                    case ADD:
                        sale.setValue(sale.getValue()+adjustment.getValue());
                        return sale;
                    case SUBTRACT:
                        sale.setValue(sale.getValue()-adjustment.getValue());
                        return sale;
                    case MULTIPLE:
                        sale.setValue(sale.getValue()*adjustment.getValue());
                        return sale;
                    default:
                        return sale;
                }
            }
            return sale;
        }).collect(Collectors.toList());
    }
}
