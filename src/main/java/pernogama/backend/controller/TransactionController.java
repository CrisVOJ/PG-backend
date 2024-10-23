package pernogama.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pernogama.backend.Globals;
import pernogama.backend.model.dto.TransactionDto;
import pernogama.backend.model.entity.TransactionEntity;
import pernogama.backend.service.ITransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Globals.apiVersion + "transaction")
public class TransactionController {

    @Autowired
    private ITransaction transactionService;

    @PostMapping("account/{accountId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TransactionDto save(@PathVariable Long accountId, @RequestBody TransactionDto transactionDto) {
        return transactionService.save(accountId, transactionDto);
    }

    @PutMapping("account/{accountId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TransactionDto update(@PathVariable Long accountId, @RequestBody TransactionDto transactionDto) {
        return transactionService.save(accountId, transactionDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDto findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDto> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("/account/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDto> findAllByAccount_AccountId(@PathVariable Long accountId) {
        return transactionService.findAllByAccount_AccountId(accountId);
    }

    @DeleteMapping("/{id}/account/{accountId}")
    public ResponseEntity<?> delete(@PathVariable Long id, @PathVariable Long accountId) {
        Map<String, Object> response = new HashMap<>();
        try {
            TransactionDto transactionDto = transactionService.findById(id);
            transactionService.deleteById(id, accountId);
            return new ResponseEntity<>(transactionDto, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            response.put("message", exDt.getMessage());
            response.put("transaction", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
