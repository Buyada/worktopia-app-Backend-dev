package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.Role;
import com.groupe.Worktopia.service.role.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    public final RoleService roleService;

    public RoleController( RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(path = "api/role/add")
    public ResponseEntity<String> addRole(@RequestBody Role role){
        this.roleService.addRole(role);

        return ResponseEntity
                .status(202)
            .body("Role added successfully !");
    }

    @GetMapping(path = "api/role/get_by_id/{roleId}")
    public ResponseEntity<Role> getRolebyId(@PathVariable Integer roleId){

        return ResponseEntity
                .status(202)
                .body(this.roleService.getRoleById(roleId));

    }

    @GetMapping(path = "api/role/get_all")
    public ResponseEntity<List<Role>> getRoles(){

        return ResponseEntity
                .status(202)
                .body( this.roleService.getRoles());

    }

    @PutMapping(path = "api/role/updatebyId/{roleId}")
    public ResponseEntity<String> updateRole(Integer roleId, @Valid @RequestBody Role role){
        this.roleService.updateRole(roleId, role);
        return  ResponseEntity
                .status(202)
                .body("Updated successfully");
    }

    @PutMapping(path = "api/role/deletebyid/{}roleId")
    public ResponseEntity<String> delRole(@PathVariable Integer roleId){
        this.roleService.deleteRole(roleId);
        return  ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
