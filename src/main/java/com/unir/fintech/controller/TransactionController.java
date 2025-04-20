package com.unir.fintech.controller;

import com.unir.fintech.model.Transaction;
import com.unir.fintech.repository.TransactionRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepository repository;

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable UUID id) {
        return repository.findById(id).orElseThrow();
    }

}
