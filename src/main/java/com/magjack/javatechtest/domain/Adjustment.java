package com.magjack.javatechtest.domain;

import lombok.Data;

@Data
public class Adjustment {

    private String product;
    private Operation operation;
    private double value;
}
