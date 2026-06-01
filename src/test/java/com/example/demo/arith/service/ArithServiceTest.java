package com.example.demo.arith.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.arith.exception.BadRequestException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ArithServiceTest {
  private ArithService arithService = new ArithService();

  private Long a;
  private Long b;

  @Nested
  class add_test {

    @Test
    void add_two_null() {
      a = null;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.add(a, b));
    }

    @Test
    void add_null_to_number() {
      a = null;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.add(a, b));
    }

    @Test
    void add_number_to_null() {
      a = 10L;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.add(a, b));
    }

    @Test
    void add_two_negative_number() {
      a = -10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.add(a, b));
    }

    @Test
    void add_negative_number_to_positive_number() {
      a = -10L;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.add(a, b));
    }

    @Test
    void add_positive_number_to_negative_number() {
      a = 10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.add(a, b));
    }

    @Test
    void add_two_small_positive_number() {
      a = 10L;
      b = 2L;

      assertEquals(BigInteger.valueOf(12), arithService.add(a, b));
    }

    @Test
    void add_two_big_positive_number() {
      a = 1000000000000L;
      b = 316800L;

      assertEquals(BigInteger.valueOf(1000000316800L), arithService.add(a, b));
    }
  }

  @Nested
  class minus_test {
    @Test
    void minus_two_null() {
      a = null;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.minus(a, b));
    }

    @Test
    void minus_null_to_number() {
      a = null;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.minus(a, b));
    }

    @Test
    void minus_number_to_null() {
      a = 10L;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.minus(a, b));
    }

    @Test
    void minus_two_negative_number() {
      a = -10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.minus(a, b));
    }

    @Test
    void minus_negative_number_to_positive_number() {
      a = -10L;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.minus(a, b));
    }

    @Test
    void minus_positive_number_to_negative_number() {
      a = 10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.minus(a, b));
    }

    @Test
    void minus_two_positive_small_number() {
      a = 10L;
      b = 2L;

      assertEquals(BigInteger.valueOf(8L), arithService.minus(a, b));
    }

    @Test
    void minus_two_small_positive_number_for_negative_result() {
      a = 10L;
      b = 20L;

      assertEquals(BigInteger.valueOf(10L).negate(), arithService.minus(a, b));
    }

    @Test
    void add_two_big_positive_number() {
      a = 1000000000000L;
      b = 316800L;

      assertEquals(BigInteger.valueOf(999999683200L), arithService.minus(a, b));
    }

    @Test
    void add_two_big_positive_number_for_negative_result() {
      a = 1000000000000L;
      b = 2000000000000L;

      assertEquals(BigInteger.valueOf(1000000000000L).negate(), arithService.minus(a, b));
    }
  }

  @Nested
  class multiply_test {

    @Test
    void multiply_two_null() {
      a = null;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.multiply(a, b));
    }

    @Test
    void multiply_null_to_number() {
      a = null;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.multiply(a, b));
    }

    @Test
    void multiply_number_to_null() {
      a = 10L;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.multiply(a, b));
    }

    @Test
    void multiply_two_negative_number() {
      a = -10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.multiply(a, b));
    }

    @Test
    void multiply_negative_number_to_positive_number() {
      a = -10L;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.multiply(a, b));
    }

    @Test
    void multiply_positive_number_to_negative_number() {
      a = 10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.multiply(a, b));
    }

    @Test
    void multiply_two_small_positive_number() {
      a = 10L;
      b = 2L;

      assertEquals(BigInteger.valueOf(20), arithService.multiply(a, b));
    }

    @Test
    void multiply_two_big_positive_number() {
      a = 1000000000000L;
      b = 316800L;

      assertEquals(new BigInteger("316800000000000000"), arithService.multiply(a, b));
    }
  }

  @Nested
  class divide_test {

    @Test
    void divide_two_null() {
      a = null;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.divide(a, b));
    }

    @Test
    void divide_null_to_number() {
      a = null;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.divide(a, b));
    }

    @Test
    void divide_number_to_null() {
      a = 10L;
      b = null;

      assertThrows(BadRequestException.class, () -> arithService.divide(a, b));
    }

    @Test
    void divide_two_negative_number() {
      a = -10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.divide(a, b));
    }

    @Test
    void divide_negative_number_to_positive_number() {
      a = -10L;
      b = 2L;

      assertThrows(BadRequestException.class, () -> arithService.divide(a, b));
    }

    @Test
    void divide_positive_number_to_negative_number() {
      a = 10L;
      b = -2L;

      assertThrows(BadRequestException.class, () -> arithService.divide(a, b));
    }

    @Test
    void divide_two_small_positive_number() {
      a = 10L;
      b = 2L;

      assertEquals(new BigDecimal("5.00"), arithService.divide(a, b));
    }

    @Test
    void divide_two_big_positive_number() {
      a = 1000000000000L;
      b = 316800L;

      assertEquals(new BigDecimal("3156565.66"), arithService.divide(a, b));
    }
  }
}
