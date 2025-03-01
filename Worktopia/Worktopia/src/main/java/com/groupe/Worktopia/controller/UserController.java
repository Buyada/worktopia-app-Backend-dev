package com.groupe.Worktopia.controller;

import com.groupe.Worktopia.entities.User;
import com.groupe.Worktopia.service.User.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "api/user/add")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user){
        this.userService.addUser(user);

        return ResponseEntity
                .status(201)
                .body("User added successfully");
    }

    @GetMapping(path = "api/user/get_by_id/{userId}")
    public ResponseEntity<User> getUser (@PathVariable Integer userId) {

        return ResponseEntity
                .status(200)
                .body(this.userService.getUser(userId));
    }

    @GetMapping(path = "api/user/get_all")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity
                .status(200)
                .body(this.userService.getUsers());
    }

    @PutMapping(path = "api/user/update_by_id")
    public ResponseEntity<String> userUpdate( Integer userId, @Valid @RequestBody User user){
        this.userService.updateUser(userId, user);

        return ResponseEntity
                .status(200)
                .body("Record updated successfully !");
    }

    @PutMapping("api/user/delete_by_id")
    public ResponseEntity<String> userToDelete(Integer userId){
        this.userService.deleteUser(userId);

        return  ResponseEntity
                .status(202)
                .body("Record deleted successfully !");
    }

}