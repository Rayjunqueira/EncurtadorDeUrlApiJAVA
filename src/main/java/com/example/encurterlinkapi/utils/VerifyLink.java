package com.example.encurterlinkapi.utils;

import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class VerifyLink {
    public Boolean verify(String url) {
        try {
            URL urlObj = new URL(url);

            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
