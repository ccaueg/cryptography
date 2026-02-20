package dev.caue.cryptography.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionRequestDto {
    private Long id;
    private String userDocument;
    private String creditCardToken;
    private Long value;
}
