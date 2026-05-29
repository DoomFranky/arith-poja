package com.example.demo.arith.service;

import com.example.demo.arith.exception.BadRequestException;
import org.springframework.stereotype.Service;


@Service
public class ArithService {
    public Long add (Long a, Long b) {
        checkIfNumberOk(a,b);
        return a + b;
    }

    public Long minus(Long a, Long b) {
        checkIfNumberOk(a,b);
        return a - b;
    }

    public Long multiply(Long a, Long b) {
        return a * b;
    }

    public Long divide(Long a, Long b) {
        return a / b;
    }

    private void checkIfNumberOk (Long a, Long b) {
        if (a==null || b==null){
            throw new BadRequestException("a and b must be defined");
        }
        if (a<0){
            throw new BadRequestException("a must be positive");
        }
        if (b<0){
            throw new BadRequestException("b must be positive");
        }
    }
}
