package pernogama.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pernogama.backend.Globals;
import pernogama.backend.model.entity.TransactionEntity;
import pernogama.backend.service.ITransaction;

import java.util.List;

@RestController
@RequestMapping(Globals.apiVersion + "transaction")
public class TransactionController {

    @Autowired
    private ITransaction transactionService;

    @PostMapping
    public TransactionEntity save(@RequestBody TransactionEntity transaction) {
        return transactionService.save(transaction);
    }

    @PutMapping
    public TransactionEntity update(@RequestBody TransactionEntity transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping("/{id}")
    public TransactionEntity findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @GetMapping
    public List<TransactionEntity> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionEntity> findAllByAccount_AccountId(@PathVariable Long accountId) {
        return transactionService.findAllByAccount_AccountId(accountId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        TransactionEntity transaction = transactionService.findById(id);
        transactionService.delete(transaction);
    }
}
