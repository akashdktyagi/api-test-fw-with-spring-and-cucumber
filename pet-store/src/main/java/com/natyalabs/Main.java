package com.natyalabs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.natyalabs.openapi.codegen",
        "com.natyalabs"
})
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}