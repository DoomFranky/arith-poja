package com.example.demo.arith.service;

import com.example.demo.arith.exception.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithServiceTest {
    private ArithService arithService = new ArithService();

    private Long a;
    private Long b;

    @Test
    void add_two_null (){
        a = null;
        b = null;

        assertThrows(BadRequestException.class, () -> arithService.add(a,b));
    }

    @Test
    void add_null_to_number (){
        a = null;
        b = 2L;

        assertThrows(BadRequestException.class, () -> arithService.add(a,b));
    }

    @Test
    void add_number_to_null (){
        a = 10L;
        b = null;

        assertThrows(BadRequestException.class, () -> arithService.add(a,b));
    }

    @Test
    void add_two_negative_number (){
        a = -10L;
        b = -2L;

        assertThrows(BadRequestException.class, () -> arithService.add(a,b));
    }

    @Test
    void add_negative_number_to_positive_number (){
        a = -10L;
        b = 2L;

        assertThrows(BadRequestException.class, () -> arithService.add(a,b));
    }

    @Test
    void add_positive_number_to_negative_number (){
        a = 10L;
        b = -2L;

        assertThrows(BadRequestException.class, () -> arithService.add(a,b));
    }

    @Test
    void add_two_small_positive_number() {
        a = 10L;
        b = 2L;

        assertEquals(12,arithService.add(a,b));
    }


}