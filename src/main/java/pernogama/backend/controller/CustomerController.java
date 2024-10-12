package pernogama.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pernogama.backend.Globals;
import pernogama.backend.model.entity.CustomerEntity;
import pernogama.backend.service.ICustomer;

@RestController
@RequestMapping(Globals.apiVersion + "customer")
public class CustomerController {

    @Autowired
    private ICustomer customerService;

    @PostMapping
    public CustomerEntity create(@RequestBody CustomerEntity customer) {
        return customerService.save(customer);
    }

    @PutMapping
    public CustomerEntity update(@RequestBody CustomerEntity customer) {
        return customerService.save(customer);
    }

    @GetMapping("/{id}")
    public CustomerEntity findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        CustomerEntity customerDelete = customerService.findById(id);
        customerService.delete(customerDelete);
    }

}
