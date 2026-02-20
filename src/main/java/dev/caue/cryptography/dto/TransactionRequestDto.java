package dev.caue.cryptography.dto;

import lombok.Data;

@Data
public class TransactionRequestDto {
    private String userDocument;
    private String creditCardToken;
    private Long value;
}