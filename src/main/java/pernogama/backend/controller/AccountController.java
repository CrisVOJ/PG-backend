package pernogama.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pernogama.backend.Globals;
import pernogama.backend.model.entity.AccountEntity;
import pernogama.backend.service.IAccount;

import java.util.List;

@RestController
@RequestMapping(Globals.apiVersion + "account")
public class AccountController {

    @Autowired
    private IAccount accountService;

    @PostMapping
    public AccountEntity create(@RequestBody AccountEntity account) {
        return accountService.save(account);
    }

    @PutMapping
    public AccountEntity update(@RequestBody AccountEntity account) {
        return accountService.save(account);
    }

    @GetMapping("/{id}")
    public AccountEntity findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @GetMapping
    public List<AccountEntity> findAll() {
        return accountService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        AccountEntity accountDelete = accountService.findById(id);
        accountService.delete(accountDelete);
    }
}
