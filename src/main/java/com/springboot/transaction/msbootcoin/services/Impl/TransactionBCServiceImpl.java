package com.springboot.transaction.msbootcoin.services.Impl;

import com.springboot.transaction.msbootcoin.documents.TransactionBCDocument;
import com.springboot.transaction.msbootcoin.repositories.TransactionBCRepository;
import com.springboot.transaction.msbootcoin.services.ITransactionBCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionBCServiceImpl implements ITransactionBCService {

    private static final Logger log = LoggerFactory.getLogger(TransactionBCServiceImpl.class);

    @Autowired
    private TransactionBCRepository transactionBCRepository;

    @Override
    public Mono<TransactionBCDocument> create(TransactionBCDocument o) {
        return transactionBCRepository.save(o);
    }

    @Override
    public Flux<TransactionBCDocument> findAll() {
        return transactionBCRepository.findAll();
    }

    @Override
    public Mono<TransactionBCDocument> findById(String s) {
        return transactionBCRepository.findById(s);
    }

    @Override
    public Mono<TransactionBCDocument> update(TransactionBCDocument o) {
        return transactionBCRepository.findById(o.getId()).flatMap(c -> {
            return transactionBCRepository.save(c);
        });
    }

    @Override
    public Mono<Void> delete(TransactionBCDocument o) {
        return transactionBCRepository.delete(o);
    }

    @Override
    public Mono<TransactionBCDocument> createTransaction(TransactionBCDocument transactionBCDocument) {
        return transactionBCRepository.save(transactionBCDocument);
    }
}
