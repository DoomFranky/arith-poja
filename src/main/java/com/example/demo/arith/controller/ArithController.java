package com.example.demo.arith.controller;

import com.example.demo.arith.exception.BadRequestException;
import com.example.demo.arith.service.ArithService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ArithController {
    private ArithService arithService;

    public ArithController (ArithService arithService) {
        this.arithService = arithService;
    }

    @GetMapping("/add")
    public ResponseEntity<?> addToNumber (@PathVariable Long a, @PathVariable Long b) {
        try {
            Long number = arithService.add(a,b);
            return ResponseEntity.ok().body(number);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}