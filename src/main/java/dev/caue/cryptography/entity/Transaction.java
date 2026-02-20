package dev.caue.cryptography.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_document", nullable = false)
    private String userDocument;

    @Column(name = "credit_card_token", nullable = false)
    private String creditCardToken;

    @Column(nullable = false)
    private Long value;
}
