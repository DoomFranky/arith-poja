package com.example.demo.arith.service;

import com.example.demo.arith.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;


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

    public BigDecimal divide(Long a, Long b) {
        checkIfNumberOk(a,b);
        if (b == 0) {
            throw new BadRequestException("b must be different of zero");
        }
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        return a1.divide(b1, 2, RoundingMode.HALF_UP);
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
