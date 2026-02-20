package dev.caue.cryptography.service;

import dev.caue.cryptography.dto.TransactionRequestDto;
import dev.caue.cryptography.dto.TransactionResponseDto;
import dev.caue.cryptography.entity.Transaction;
import dev.caue.cryptography.exception.TransactionNotFoundException;
import dev.caue.cryptography.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionResponseDto create(TransactionRequestDto dto) {
        Transaction transaction = new Transaction(
                null,
                dto.getUserDocument(),
                dto.getCreditCardToken(),
                dto.getValue()
        );
        Transaction saved = repository.save(transaction);

        return toResponse(saved);
    }

    public List<TransactionResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TransactionResponseDto findById(Long id) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        return toResponse(transaction);
    }

    public TransactionResponseDto update(Long id, TransactionRequestDto dto) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        transaction.setUserDocument(dto.getUserDocument());
        transaction.setCreditCardToken(dto.getCreditCardToken());
        transaction.setValue(dto.getValue());

        Transaction updated = repository.save(transaction);
        return toResponse(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TransactionNotFoundException(id);
        }

        repository.deleteById(id);
    }

    private TransactionResponseDto toResponse(Transaction transaction) {
        return new TransactionResponseDto(
                transaction.getId(),
                transaction.getUserDocument(),
                transaction.getCreditCardToken(),
                transaction.getValue()
        );
    }
}