package com.example.demo.arith.controller;

import com.example.demo.arith.exception.BadRequestException;
import com.example.demo.arith.service.ArithService;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithController {
  private ArithService arithService;

  public ArithController(ArithService arithService) {
    this.arithService = arithService;
  }

  @GetMapping("/add")
  public ResponseEntity<?> addTwoNumber(@RequestParam Long a, @RequestParam Long b) {
    try {
      BigInteger number = arithService.add(a, b);
      return ResponseEntity.ok().body(number);
    } catch (BadRequestException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/minus")
  public ResponseEntity<?> minusTwoNumber(@RequestParam Long a, @RequestParam Long b) {
    try {
      BigInteger number = arithService.minus(a, b);
      return ResponseEntity.ok().body(number);
    } catch (BadRequestException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/multiply")
  public ResponseEntity<?> multiplyTwoNumber(@RequestParam Long a, @RequestParam Long b) {
    try {
      BigInteger number = arithService.multiply(a, b);
      return ResponseEntity.ok().body(number);
    } catch (BadRequestException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/divide")
  public ResponseEntity<?> divideToNumber(@RequestParam Long a, @RequestParam Long b) {
    try {
      BigDecimal number = arithService.divide(a, b);
      return ResponseEntity.ok().body(number);
    } catch (BadRequestException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
}
