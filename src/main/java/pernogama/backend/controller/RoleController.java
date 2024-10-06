package pernogama.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pernogama.backend.model.entity.RoleEntity;
import pernogama.backend.service.IRole;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private IRole roleService;

    @PostMapping
    public RoleEntity create(@RequestBody RoleEntity role) {
        return roleService.save(role);
    }

    @PutMapping
    public RoleEntity update(@RequestBody RoleEntity role) {
        return roleService.save(role);
    }

    @GetMapping("/{id}")
    public RoleEntity findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        RoleEntity roleDelete = roleService.findById(id);
        roleService.delete(roleDelete);
    }

}
