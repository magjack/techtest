package com.magjack.javatechtest.services;

import com.magjack.javatechtest.domain.Adjustment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdjustmentService {

    @Autowired
    List<Adjustment> adjustments;

    public void addAdjustment(Adjustment newAdjustment) {
        adjustments.add(newAdjustment);
    }

    public List<Adjustment> getAdjustments() {
        return adjustments;
    }
}
