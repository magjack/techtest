package com.magjack.javatechtest.config;

import com.magjack.javatechtest.domain.Adjustment;
import com.magjack.javatechtest.domain.Sale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RepoConfig {

    @Bean
    List<Sale> createSaleRepo(){
        return new ArrayList<Sale>();
    }

    @Bean
    List<Adjustment> createAdjustmentRepo(){
        return new ArrayList<Adjustment>();
    }
}
