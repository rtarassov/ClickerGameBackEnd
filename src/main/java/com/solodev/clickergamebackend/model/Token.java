package com.solodev.clickergamebackend.model;

public record Token(String value) {

    public Token {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Token value cannot be null or blank");
        }
    }
}
