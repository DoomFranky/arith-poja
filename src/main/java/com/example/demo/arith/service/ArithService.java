package com.example.demo.arith.service;

import com.example.demo.arith.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;


@Service
public class ArithService {
    public BigInteger add (Long a, Long b) {
        checkIfNumberOk(a,b);
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);
        return a1.add(b1);
    }

    public BigInteger minus(Long a, Long b) {
        checkIfNumberOk(a,b);
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);
        return a1.subtract(b1);
    }

    public BigInteger multiply(Long a, Long b) {
        checkIfNumberOk(a,b);
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);
        return a1.multiply(b1);
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
