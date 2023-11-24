package com.example.encurterlinkapi.utils;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateEncurterCode {
    Random random = new Random();
    public int generateCode() {
        int code = 0;

        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            code = code * 10 + digit;
        }

        return code;
    }
}
