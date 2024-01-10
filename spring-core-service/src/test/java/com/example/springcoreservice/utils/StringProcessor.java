package com.example.springcoreservice.utils;

import org.springframework.stereotype.Component;

@Component
public class StringProcessor {
    public static Boolean containsSubstring(String mainString, String substringToFind) {
        return mainString.contains(substringToFind);
    }
}