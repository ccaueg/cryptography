package dev.caue.cryptography.entity;

import dev.caue.cryptography.converter.EncryptedStringConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(name = "user_document", nullable = false)
    private String userDocument;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(name = "credit_card_token", nullable = false)
    private String creditCardToken;

    @Column(nullable = false)
    private Long value;
}
