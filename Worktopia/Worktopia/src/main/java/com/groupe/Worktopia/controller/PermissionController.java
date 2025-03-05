package com.groupe.Worktopia.controller;


import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.entities.Conge;
import com.groupe.Worktopia.entities.Permission;
import com.groupe.Worktopia.service.Permission.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @Operation(summary = "add new Permission ", description = "Allow to add new Permission")
    @PostMapping("api/p1/Permission/add")
    public ResponseEntity<Permission> addPermission(@RequestBody @Valid Permission permission){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.permissionService.addPermission(permission));

    }


    @GetMapping(path = "api/p1/permission/get_all_permission")
    public  ResponseEntity<List<Permission>> getAllPermission(){
        return ResponseEntity.status(200).body(this.permissionService.getAllPermission());

    }

    @GetMapping(path = "api/p1/permission/get_by_id/{idPermission}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long idPermission){
        return ResponseEntity
                .status(200)
                .body(this.permissionService.getPermissionById(idPermission));
    }


    @PutMapping(path = "api/p1/permission/update_by_id/{idPermission}")
    public ResponseEntity<Permission> updatePermission(@PathVariable Long idPermission,
                                                 @RequestBody Permission permission){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.permissionService.updatePermission(permission,idPermission));
    }


    @DeleteMapping("api/p1/permission/delete_by_id/{idPermission}")
    public ResponseEntity<String> deletePermissionById(@PathVariable Long idPermission){
        this.permissionService.deletePermission(idPermission);
        return ResponseEntity
                .status(202)
                .body("This permission has been deleted successfully ! ");
    }

}
