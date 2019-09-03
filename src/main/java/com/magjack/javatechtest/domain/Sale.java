package com.magjack.javatechtest.domain;

import lombok.Data;

@Data
public class Sale {

    private String product;
    private double value;
    private int quantity=1;

    public double getTotal(){
        return value* Double.valueOf(quantity);
    }

}

